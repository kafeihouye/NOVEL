package com.nsdciot.novel.service;


import com.nsdciot.novel.entity.FriendLink;

import java.util.List;

/**
 * @author 11797
 */
public interface FriendLinkService {

    /**
     * 查询首页友情链接
     * @return 集合
     * */
    List<FriendLink> listIndexLink();
}
