package com.nsdciot.novel.service.impl;

import com.nsdciot.novel.core.utils.Constants;
import com.nsdciot.novel.core.utils.FileUtil;
import com.nsdciot.novel.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author 11797
 */
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "pic.save", name = "storage", havingValue = "local")
public class LocalFileServiceImpl implements FileService {

    @Override
    public String transFile(String picSrc, String picSavePath){

        return FileUtil.network2Local(picSrc, picSavePath, Constants.LOCAL_PIC_PREFIX);
    }
}
