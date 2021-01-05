package com.briup.estore.mapper;

import com.briup.estore.bean.EOrder;
import java.util.List;

public interface EOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EOrder record);

    EOrder selectByPrimaryKey(Integer id);

    List<EOrder> selectAll();

    int updateByPrimaryKey(EOrder record);
    
    int saveOrder(EOrder order);
    
    List<EOrder> selectOrderAndOrderlineByCusId(int customer_id);
}