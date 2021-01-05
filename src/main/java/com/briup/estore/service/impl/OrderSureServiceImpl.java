package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EOrder;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.EOrderMapper;
import com.briup.estore.mapper.EOrderlineMapper;
import com.briup.estore.service.IOrderSureService;

public class OrderSureServiceImpl implements IOrderSureService{

	@Override
	public int savaOrder(EOrder order) throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		try {
			EOrderMapper mapper = session.getMapper(EOrderMapper.class);
			EOrderlineMapper orderlineMapper = session.getMapper(EOrderlineMapper.class);
			/*
			 * for(EOrderline line:order.getLine()) { line.setOrderId(order.getId());
			 * orderlineMapper.insert(line); }
			 */
			mapper.saveOrder(order);
			int count = orderlineMapper.saveOrderLines(order.getLine(), order.getId());
			session.commit();
			return count;
		} catch (UserException e) {
			session.rollback();
			e.printStackTrace();
			throw new UserException(e);
		}finally {
			session.close();
		}
	}

}
