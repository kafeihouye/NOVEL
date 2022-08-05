package com.nsdciot.novel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nsdciot.novel.core.serialize.CommentUserNameSerialize;
import com.nsdciot.novel.entity.BookComment;
import lombok.Data;

import java.util.Date;

/**
 * @author 11797
 */
@Data
public class BookCommentVO extends BookComment {

    @JsonSerialize(using = CommentUserNameSerialize.class)
    private String createUserName;

    private String createUserPhoto;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Override
    public String toString() {
        return super.toString();
    }
}
