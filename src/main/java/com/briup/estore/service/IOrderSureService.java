package com.briup.estore.service;

import com.briup.estore.bean.EOrder;
import com.briup.estore.common.exceptions.UserException;

public interface IOrderSureService {

	int savaOrder(EOrder order) throws UserException;
}
