package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EOrder;
import com.briup.estore.bean.EOrderline;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.EBookMapper;
import com.briup.estore.mapper.EOrderMapper;
import com.briup.estore.service.IOrderService;

public class OrderServiceImpl implements IOrderService{

	@Override
	public List<EOrder> getOrders(int cusId) throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		try {
			EOrderMapper orderMapper = session.getMapper(EOrderMapper.class);
			EBookMapper bookMapper = session.getMapper(EBookMapper.class);
			List<EOrder> orders = orderMapper.selectOrderAndOrderlineByCusId(cusId);
			for (int i = 0; i < orders.size(); i++) {
				for(EOrderline line:orders.get(i).getLine()) {
					line.setBook(bookMapper.selectByPrimaryKey(line.getBookId()));
				}
			}
			return orders;
		} finally {
			session.close();
		}
	}

}
