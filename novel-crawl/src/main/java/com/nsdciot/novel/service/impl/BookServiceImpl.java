package com.nsdciot.novel.service.impl;

import com.nsdciot.novel.entity.Book;
import com.nsdciot.novel.utils.Constants;
import com.nsdciot.novel.entity.BookContent;
import com.nsdciot.novel.entity.BookIndex;
import com.nsdciot.novel.service.BookContentService;
import com.nsdciot.novel.service.BookService;
import com.nsdciot.novel.mapper.BookCategoryDynamicSqlSupport;
import com.nsdciot.novel.mapper.BookCategoryMapper;
import com.nsdciot.novel.mapper.BookDynamicSqlSupport;
import com.nsdciot.novel.mapper.BookIndexDynamicSqlSupport;
import com.nsdciot.novel.mapper.CrawlBookIndexMapper;
import com.nsdciot.novel.mapper.CrawlBookMapper;
import com.nsdciot.novel.mapper.CrawlSourceDynamicSqlSupport;
import lombok.RequiredArgsConstructor;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * @author Administrator
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final CrawlBookMapper bookMapper;

    private final BookCategoryMapper bookCategoryMapper;

    private final CrawlBookIndexMapper bookIndexMapper;

    private final Map<String, BookContentService> bookContentServiceMap;

    @Value("${content.save.storage}")
    private String storageType;


    @Override
    public boolean queryIsExistByBookNameAndAuthorName(String bookName, String authorName) {

        return bookMapper.count(countFrom(BookDynamicSqlSupport.book).where(BookDynamicSqlSupport.bookName, isEqualTo(bookName))
                .and(BookDynamicSqlSupport.authorName, isEqualTo(authorName))
                .build()
                .render(RenderingStrategies.MYBATIS3)) > 0;

    }

    @Override
    public void updateCrawlProperties(Long id, Integer sourceId, String bookId) {
        bookMapper.update(update(BookDynamicSqlSupport.book)
                .set(BookDynamicSqlSupport.crawlSourceId)
                .equalTo(sourceId)
                .set(BookDynamicSqlSupport.crawlBookId)
                .equalTo(bookId)
                .where(BookDynamicSqlSupport.id, isEqualTo(id))
                .build()
                .render(RenderingStrategies.MYBATIS3));
    }

    @Override
    public String queryCatNameByCatId(int catId) {
        return bookCategoryMapper.selectMany(SelectDSL.select(BookCategoryDynamicSqlSupport.name)
                .from(BookCategoryDynamicSqlSupport.bookCategory)
                .where(CrawlSourceDynamicSqlSupport.id, isEqualTo(catId))
                .build()
                .render(RenderingStrategies.MYBATIS3)).get(0).getName();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBookAndIndexAndContent(Book book, List<BookIndex> bookIndexList, List<BookContent> bookContentList) {
        if (!queryIsExistByBookNameAndAuthorName(book.getBookName(), book.getAuthorName())) {

            if (bookIndexList.size() > 0) {

                //保存小说主表

                book.setCreateTime(new Date());
                bookMapper.insertSelective(book);

                //批量保存目录和内容
                bookIndexList.forEach(bookIndex -> {
                    bookIndex.setStorageType(storageType);
                });
                bookIndexMapper.insertMultiple(bookIndexList);
                bookContentServiceMap.get(storageType).saveBookContent(bookContentList, book.getId());

            }
        }


    }

    @Override
    public List<Book> queryNeedUpdateBook(Date startDate, int limit) {
        List<Book> books = bookMapper.queryNeedUpdateBook(startDate, limit);
        if (books.size() > 0) {
            //更新最后抓取时间为当前时间
            bookMapper.updateCrawlLastTime(books, new Date());
        }
        return books;
    }

    @Override
    public Map<Integer, BookIndex> queryExistBookIndexMap(Long bookId) {
        List<BookIndex> bookIndexs = bookIndexMapper.selectMany(SelectDSL
            .select(BookIndexDynamicSqlSupport.id, BookIndexDynamicSqlSupport.indexNum, BookIndexDynamicSqlSupport.indexName, BookIndexDynamicSqlSupport.wordCount, BookIndexDynamicSqlSupport.storageType)
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.bookId, isEqualTo(bookId))
                .build()
                .render(RenderingStrategies.MYBATIS3));
        if (bookIndexs.size() > 0) {
            return bookIndexs.stream().collect(Collectors.toMap(BookIndex::getIndexNum, Function.identity()));
        }
        return new HashMap<>(0);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateBookAndIndexAndContent(Book book, List<BookIndex> bookIndexList, List<BookContent> bookContentList, Map<Integer, BookIndex> existBookIndexMap) {
        for (int i = 0; i < bookIndexList.size(); i++) {
            BookIndex bookIndex = bookIndexList.get(i);
            BookContent bookContent = bookContentList.get(i);


            if (!existBookIndexMap.containsKey(bookIndex.getIndexNum())) {
                //插入
                bookIndex.setStorageType(storageType);
                bookIndexMapper.insertSelective(bookIndex);
                bookContentServiceMap.get(storageType).saveBookContent(bookContent, book.getId());
            } else {
                //更新
                bookIndexMapper.updateByPrimaryKeySelective(bookIndex);
                bookContentServiceMap.get(existBookIndexMap.get(bookIndex.getIndexNum()).getStorageType()).updateBookContent(bookContent, book.getId());
            }


        }

        //更新小说主表
        book.setBookName(null);
        book.setAuthorName(null);
        if (Constants.VISIT_COUNT_DEFAULT.equals(book.getVisitCount())) {
            book.setVisitCount(null);
        }
        bookMapper.updateByPrimaryKeySelective(book);

    }

    @Override
    public void updateCrawlLastTime(Long bookId) {
        Book book = new Book();
        book.setId(bookId);
        book.setCrawlLastTime(new Date());
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public Book queryBookByBookNameAndAuthorName(String bookName, String authorName) {
        List<Book> books = bookMapper.selectMany(select(BookDynamicSqlSupport.id).from(BookDynamicSqlSupport.book)
                .where(BookDynamicSqlSupport.bookName, isEqualTo(bookName))
                .and(BookDynamicSqlSupport.authorName, isEqualTo(authorName))
                .build()
                .render(RenderingStrategies.MYBATIS3));

        if (books.size() > 0) {
            return books.get(0);
        }

        return null;

    }

}
