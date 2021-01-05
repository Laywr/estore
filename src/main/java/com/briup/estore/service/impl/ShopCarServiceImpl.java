package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EBook;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.EBookMapper;
import com.briup.estore.service.IShopCarService;

public class ShopCarServiceImpl implements IShopCarService{

	@Override
	public void addToCar(ShoppingCar car, int bookId, int num) throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		try {
			EBookMapper mapper = session.getMapper(EBookMapper.class);
			EBook book = mapper.selectByPrimaryKey(bookId);
			car.add(book, num);
		} finally {
			session.close();
		}
		
	}

}
