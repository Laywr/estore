package com.briup.estore.common.utils;

import static com.briup.estore.common.utils.MyBatisUtils.openSession;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;

import com.briup.estore.common.annotation.AutoSet;
import com.briup.estore.service.IUserService;

public class BeanFactory {
	private static Properties prop = new Properties();
	public static final String USER_SERVICE="userService";
	static {
		try {
			prop.load(Resources.getResourceAsStream("beans.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static <T> T getBean(String name) {
		try {
			Class c = Class.forName(prop.getProperty(name));
			Object target = c.newInstance();
			Field[] fs = c.getDeclaredFields();
			if(fs!=null&&fs.length>0) {
				for(Field f:fs) {
					if(f.getAnnotation(AutoSet.class)!=null) {
						//f.setAccessible(true);
						SqlSession session = openSession();
						f.setAccessible(true);
						f.set(target, session.getMapper(f.getType()));
					}
				}
			}
			return (T)target;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		IUserService service = getBean(USER_SERVICE);
		Field[] fs = service.getClass().getDeclaredFields();
		try {
			SqlSession session = (SqlSession)fs[0].get(service);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fs);
	}
}
