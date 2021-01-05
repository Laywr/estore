package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.ECustomerMapper;
import com.briup.estore.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public boolean registUser(ECustomer cus) throws UserException{
		SqlSession session = MyBatisUtils.openSession();
		try {
			ECustomerMapper mapper = session.getMapper(ECustomerMapper.class);
			ECustomer customer = mapper.selectByName(cus.getUsername());
			if(customer!=null) {
				throw new UserException("用户已存在");
			}
			mapper.insert(cus);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new UserException(e.getMessage(),e);
		}finally {
			session.close();
		}
	}

	@Override
	public ECustomer loginUser(String name, String pwd) throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		ECustomer customer = null;
		try {
			ECustomerMapper mapper = session.getMapper(ECustomerMapper.class);
			customer = mapper.selectByName(name);
			if(customer==null) {
				throw new UserException("用户名错误");
			}else if(!pwd.equals(customer.getPassword())){
				throw new UserException("密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException(e.getMessage(),e);
		}finally {
			session.close();
		}
		return customer;
	}

}
