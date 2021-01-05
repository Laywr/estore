package com.briup.estore.mapper;

import com.briup.estore.bean.EBook;
import java.util.List;

public interface EBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EBook record);

    EBook selectByPrimaryKey(Integer id);

    List<EBook> selectAll();

    int updateByPrimaryKey(EBook record);
    
    List<EBook> findBookByName(String name);
}