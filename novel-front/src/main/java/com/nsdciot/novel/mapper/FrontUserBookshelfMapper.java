package com.nsdciot.novel.mapper;

import com.nsdciot.novel.vo.BookShelfVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface FrontUserBookshelfMapper extends UserBookshelfMapper {

    List<BookShelfVO> listBookShelf(@Param("userId") Long userId);

}
