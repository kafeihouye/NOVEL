package com.nsdciot.novel.mapper;

import com.nsdciot.novel.vo.BookSettingVO;

import java.util.List;

/**
 * @author Administrator
 */
public interface FrontBookSettingMapper extends BookSettingMapper {

    List<BookSettingVO> listVO();
}
