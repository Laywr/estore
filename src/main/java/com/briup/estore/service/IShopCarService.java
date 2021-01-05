package com.briup.estore.service;

import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exceptions.UserException;

public interface IShopCarService {

	void addToCar(ShoppingCar car,int bookId,int num)throws UserException;
}
