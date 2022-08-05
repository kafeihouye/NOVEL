package com.nsdciot.novel.service;

import com.nsdciot.novel.entity.BookContent;

public interface BookContentService {

    BookContent queryBookContent(Long bookId, Long bookIndexId);

}
