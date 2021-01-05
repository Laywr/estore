package com.briup.estore.service;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exceptions.UserException;

public interface IUserService {

	boolean registUser(ECustomer cus) throws UserException;
	
	ECustomer loginUser(String name,String pwd) throws UserException;
}
