package com.nsdciot.novel.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xxyopen.model.page.PageBean;
import com.nsdciot.novel.core.enums.ResponseStatus;
import io.github.xxyopen.util.StringUtil;
import io.github.xxyopen.web.exception.BusinessException;
import com.nsdciot.novel.entity.Book;
import com.nsdciot.novel.vo.BookSpVO;
import com.nsdciot.novel.service.SearchService;
import com.nsdciot.novel.vo.EsBookVO;
import io.searchbox.client.JestClient;
import io.searchbox.core.Count;
import io.searchbox.core.CountResult;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 11797
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final JestClient jestClient;

    private final RestHighLevelClient restHighLevelClient;

    private final String INDEX = "novel";


    @Override
    @SneakyThrows
    public void importToEs(Book book) {
        //导入到ES
        EsBookVO esBookVO = new EsBookVO();
        BeanUtils.copyProperties(book, esBookVO, "lastIndexUpdateTime");
        esBookVO.setLastIndexUpdateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(book.getLastIndexUpdateTime()));

        IndexRequest request = new IndexRequest(INDEX);
        request.id(book.getId()+"");
        request.source(new ObjectMapper().writeValueAsString(esBookVO), XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        log.debug(index.getResult().toString());

    }

    @SneakyThrows
    @Override
    public PageBean<EsBookVO> searchBook(BookSpVO params, int page, int pageSize) {
        List<EsBookVO> bookList = new ArrayList<>(0);

        //使用搜索引擎搜索
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 构造查询哪个字段
        if (StringUtils.isNoneBlank(params.getKeyword())) {
            boolQueryBuilder = boolQueryBuilder.must(QueryBuilders.queryStringQuery(params.getKeyword()));
        }

        // 作品方向
        if (params.getWorkDirection() != null) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("workDirection", params.getWorkDirection()));
        }

        // 分类
        if (params.getCatId() != null) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("catId", params.getCatId()));
        }
        if (params.getBookStatus() != null) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("bookStatus", params.getBookStatus()));
        }

        if (params.getWordCountMin() == null) {
            params.setWordCountMin(0);
        }
        if (params.getWordCountMax() == null) {
            params.setWordCountMax(Integer.MAX_VALUE);
        }

        boolQueryBuilder.filter(QueryBuilders.rangeQuery("wordCount").gte(params.getWordCountMin()).lte(params.getWordCountMax()));

        if (params.getUpdateTimeMin() != null) {
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("lastIndexUpdateTime").gte(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(params.getUpdateTimeMin())));
        }



        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);


        Count count = new Count.Builder().addIndex(INDEX)
                .query(searchSourceBuilder.toString()).build();
        CountResult results = jestClient.execute(count);
        Double total = results.getCount();


        // 高亮字段
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("authorName");
        highlightBuilder.field("bookName");
        highlightBuilder.field("bookDesc");
        highlightBuilder.field("lastIndexName");
        highlightBuilder.field("catName");
        highlightBuilder.preTags("<span style='color:red'>").postTags("</span>");
        highlightBuilder.fragmentSize(20000);
        searchSourceBuilder.highlighter(highlightBuilder);


        //设置排序
        if (params.getSort() != null) {
            searchSourceBuilder.sort(StringUtil.camelName(params.getSort()), SortOrder.DESC);
        }

        // 设置分页
        searchSourceBuilder.from((page - 1) * pageSize);
        searchSourceBuilder.size(pageSize);

        // 构建Search对象
        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(INDEX).build();
        log.debug(search.toString());
        SearchResult result;
        result = jestClient.execute(search);
        log.debug(result.getJsonString());
        if (result.isSucceeded()) {

            Map resultMap = new ObjectMapper().readValue(result.getJsonString(), Map.class);
            if (resultMap.get("hits") != null) {
                Map hitsMap = (Map) resultMap.get("hits");
                if (hitsMap.size() > 0 && hitsMap.get("hits") != null) {
                    List hitsList = (List) hitsMap.get("hits");
                    if (hitsList.size() > 0 && result.getSourceAsString() != null) {

                        JavaType jt = new ObjectMapper().getTypeFactory().constructParametricType(ArrayList.class, EsBookVO.class);
                        bookList = new ObjectMapper().readValue("[" + result.getSourceAsString() + "]", jt);

                        if (bookList != null) {
                            for (int i = 0; i < bookList.size(); i++) {
                                hitsMap = (Map) hitsList.get(i);
                                Map highlightMap = (Map) hitsMap.get("highlight");
                                if (highlightMap != null && highlightMap.size() > 0) {

                                    List<String> authorNameList = (List<String>) highlightMap.get("authorName");
                                    if (authorNameList != null && authorNameList.size() > 0) {
                                        bookList.get(i).setAuthorName(authorNameList.get(0));
                                    }

                                    List<String> bookNameList = (List<String>) highlightMap.get("bookName");
                                    if (bookNameList != null && bookNameList.size() > 0) {
                                        bookList.get(i).setBookName(bookNameList.get(0));
                                    }

                                    List<String> bookDescList = (List<String>) highlightMap.get("bookDesc");
                                    if (bookDescList != null && bookDescList.size() > 0) {
                                        bookList.get(i).setBookDesc(bookDescList.get(0));
                                    }

                                    List<String> lastIndexNameList = (List<String>) highlightMap.get("lastIndexName");
                                    if (lastIndexNameList != null && lastIndexNameList.size() > 0) {
                                        bookList.get(i).setLastIndexName(lastIndexNameList.get(0));
                                    }

                                    List<String> catNameList = (List<String>) highlightMap.get("catName");
                                    if (catNameList != null && catNameList.size() > 0) {
                                        bookList.get(i).setCatName(catNameList.get(0));
                                    }


                                }
                            }


                        }
                    }
                }
            }
            return new PageBean<>(page, pageSize, total.longValue(), bookList);
        }
       throw new BusinessException(ResponseStatus.ES_SEARCH_FAIL);
    }



}
