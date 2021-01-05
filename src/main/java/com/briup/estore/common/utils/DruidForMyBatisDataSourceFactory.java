package com.briup.estore.common.utils;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidForMyBatisDataSourceFactory implements DataSourceFactory {
	private Properties props;
	@Override
	public void setProperties(Properties props) {
		this.props = props;
	}

	@Override
	public DataSource getDataSource() {
		try {
			return DruidDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
