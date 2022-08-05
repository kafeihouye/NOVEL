package com.nsdciot.novel.service.impl;

import com.nsdciot.novel.service.BookContentService;
import com.nsdciot.novel.core.utils.FileUtil;
import com.nsdciot.novel.entity.BookContent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "txt")
@RequiredArgsConstructor
public class FileBookContentServiceImpl implements BookContentService {

    @Value("${content.save.path}")
    private String fileSavePath;

    @Override
    public void saveBookContent(List<BookContent> bookContentList,Long bookId) {
        bookContentList.forEach(bookContent -> saveBookContent(bookContent,bookId));

    }

    @Override
    public void saveBookContent(BookContent bookContent,Long bookId) {
        FileUtil.writeContentToFile(fileSavePath,"/"+bookId+"/"+bookContent.getIndexId()+".txt",bookContent.getContent());
    }

    @Override
    public void updateBookContent(BookContent bookContent,Long bookId) {
        FileUtil.writeContentToFile(fileSavePath,"/"+bookId+"/"+bookContent.getIndexId()+".txt",bookContent.getContent());
    }
}
