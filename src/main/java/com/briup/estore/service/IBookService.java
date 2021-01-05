package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exceptions.UserException;

public interface IBookService {

	List<EBook> getAllBooks() throws UserException;
	
	EBook getBookById(int bookId) throws UserException;
	
	List<EBook> getBookByName(String name) throws UserException;
}
