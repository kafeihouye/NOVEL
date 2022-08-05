package com.nsdciot.novel.service;


import com.nsdciot.novel.entity.Book;
import com.nsdciot.novel.vo.BookSpVO;
import com.nsdciot.novel.vo.EsBookVO;

/**
 * @author 11797
 */
public interface SearchService {

    /**
     * 导入到es
     * @param book 小说数据
     */
    void importToEs(Book book);

    /**
     * 搜索
     * @param params 搜索参数
     * @param page 当前页码
     * @param pageSize 每页大小
     * @return 分页信息
     */
    io.github.xxyopen.model.page.PageBean<EsBookVO> searchBook(BookSpVO params, int page, int pageSize);
}
