package com.nsdciot.novel.service.impl;

import com.nsdciot.novel.mapper.BookContentDynamicSqlSupport;
import com.nsdciot.novel.mapper.BookContentMapper;
import com.nsdciot.novel.entity.BookContent;
import com.nsdciot.novel.service.BookContentService;
import lombok.RequiredArgsConstructor;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.update;


@Service(value = "db")
@RequiredArgsConstructor
public class DbBookContentServiceImpl implements BookContentService {

    private final BookContentMapper bookContentMapper;

    @Override
    public void saveBookContent(List<BookContent> bookContentList,Long bookId) {
        bookContentMapper.insertMultiple(bookContentList);
    }

    @Override
    public void saveBookContent(BookContent bookContent,Long bookId) {
        bookContentMapper.insertSelective(bookContent);
    }

    @Override
    public void updateBookContent(BookContent bookContent,Long bookId) {
        bookContentMapper.update(update(BookContentDynamicSqlSupport.bookContent)
                .set(BookContentDynamicSqlSupport.content)
                .equalTo(bookContent.getContent())
                .where(BookContentDynamicSqlSupport.indexId,isEqualTo(bookContent.getIndexId()))
                .build()
                .render(RenderingStrategies.MYBATIS3));
    }
}
