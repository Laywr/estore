package com.briup.estore.mapper;

import com.briup.estore.bean.ECategory;
import java.util.List;

public interface ECategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ECategory record);

    ECategory selectByPrimaryKey(Integer id);

    List<ECategory> selectAll();

    int updateByPrimaryKey(ECategory record);
    
    List<ECategory> selectAllWithSonCategory();
}