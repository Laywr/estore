package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.EOrder;
import com.briup.estore.common.exceptions.UserException;

public interface IOrderService {

	List<EOrder> getOrders(int cusId)throws UserException;
}
