package com.briup.estore.mapper;

import com.briup.estore.bean.EOrderline;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EOrderlineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EOrderline record);

    EOrderline selectByPrimaryKey(Integer id);

    List<EOrderline> selectAll();

    int updateByPrimaryKey(EOrderline record);
    
    int saveOrderLines(
    		@Param("lines")Collection<EOrderline> lines,
    		@Param("orderId")int orderId);
}