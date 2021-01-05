package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.EBookMapper;
import com.briup.estore.service.IBookService;

public class EBookServiceImpl implements IBookService{

	@Override
	public List<EBook> getAllBooks() throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		EBookMapper mapper = session.getMapper(EBookMapper.class);
		List<EBook> ebooks = mapper.selectAll();
		session.close();
		return ebooks;
	}

	@Override
	public EBook getBookById(int bookId) throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		EBookMapper mapper = session.getMapper(EBookMapper.class);
		EBook book = mapper.selectByPrimaryKey(bookId);
		session.close();
		return book;
	}

	@Override
	public List<EBook> getBookByName(String name) throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		EBookMapper mapper = session.getMapper(EBookMapper.class);
		List<EBook> book = mapper.findBookByName(name);
		session.close();
		return book;
	}
	

	
}
