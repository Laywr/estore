package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ECategory;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.ECategoryMapper;
import com.briup.estore.service.ICategoryService;

public class ECategoryServiceImpl implements ICategoryService{

	@Override
	public List<ECategory> getAllCategory() throws UserException {
		SqlSession session = MyBatisUtils.openSession();
		List<ECategory> categories;
		try {
			ECategoryMapper mapper = session.getMapper(ECategoryMapper.class);
			categories = mapper.selectAllWithSonCategory();
			return categories;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}return null;
		
	}

}
