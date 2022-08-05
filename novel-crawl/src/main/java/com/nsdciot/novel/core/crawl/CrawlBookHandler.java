package com.nsdciot.novel.core.crawl;

import com.nsdciot.novel.entity.Book;

/**
 * 爬虫小说处理器
 * */
public interface CrawlBookHandler {

    void handle(Book book);

}
