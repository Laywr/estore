package com.briup.estore.mapper;

import com.briup.estore.bean.ECustomer;
import java.util.List;

public interface ECustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ECustomer record);

    ECustomer selectByPrimaryKey(Integer id);

    List<ECustomer> selectAll();

    int updateByPrimaryKey(ECustomer record);
    
    ECustomer selectByName(String name);
}