package com.nsdciot.novel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.nsdciot.novel.dao.BookDao;
import com.nsdciot.novel.domain.BookDO;
import com.nsdciot.novel.service.BookService;



@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	@Override
	public BookDO get(Long id){
		return bookDao.get(id);
	}
	
	@Override
	public List<BookDO> list(Map<String, Object> map){
		return bookDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bookDao.count(map);
	}
	
	@Override
	public int save(BookDO book){
		return bookDao.save(book);
	}
	
	@Override
	public int update(BookDO book){
		return bookDao.update(book);
	}
	
	@Override
	public int remove(Long id){
		return bookDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return bookDao.batchRemove(ids);
	}

	@Override
	public Map<Object, Object> tableSta(Date minDate) {
		List<Map<Object, Object>> maps = bookDao.tableSta(minDate);

		return maps.stream().collect(Collectors.toMap(x -> x.get("staDate"), x -> x.get("bookCount")));

	}

}
