package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.ECategory;
import com.briup.estore.common.exceptions.UserException;

public interface ICategoryService {

	List<ECategory> getAllCategory() throws UserException;
}
