package com.briup.estore.mapper;

import com.briup.estore.bean.EShopcar;
import java.util.List;

public interface EShopcarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EShopcar record);

    EShopcar selectByPrimaryKey(Integer id);

    List<EShopcar> selectAll();

    int updateByPrimaryKey(EShopcar record);
}