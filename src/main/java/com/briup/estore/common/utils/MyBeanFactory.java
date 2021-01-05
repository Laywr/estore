package com.briup.estore.common.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.service.impl.EBookServiceImpl;
import com.briup.estore.service.impl.ECategoryServiceImpl;

public class MyBeanFactory {

	public static final String USER_SERVICE = "userService";
	public static final String BOOK_SERVICE = "bookService";
	public static final String CATE_SERVICE = "cateService";
	public static final String ORDERSURE_SERVICE = "orderSureService";
	public static final String ORDER_SERVICE = "orderService";
	
	private static Properties props = new Properties();
	static {
		try {
			props.load(Resources.getResourceAsStream("beans.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static <T> T getBean(String name) {
		try {
			return (T)Class.forName(props.getProperty(name)).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException(e);
		}
	}
	public static void main(String[] args) {
		EBookServiceImpl bookservice = getBean(BOOK_SERVICE);
		System.out.println(bookservice);
		ECategoryServiceImpl cateservice = getBean(CATE_SERVICE);
		System.out.println(cateservice);
	}
}
