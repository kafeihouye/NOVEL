package com.nsdciot.novel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsdciot.novel.entity.CrawlSingleTask;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CrawlSingleTaskVO extends CrawlSingleTask {

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;




    @Override
    public String toString() {
        return super.toString();
    }
}
