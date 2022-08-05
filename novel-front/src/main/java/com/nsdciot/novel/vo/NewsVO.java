package com.nsdciot.novel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsdciot.novel.entity.News;
import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class NewsVO extends News {

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createTime;
}
