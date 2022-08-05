package com.nsdciot.common.service;

import org.springframework.stereotype.Service;

import com.nsdciot.common.domain.LogDO;
import com.nsdciot.common.domain.PageDO;
import com.nsdciot.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
