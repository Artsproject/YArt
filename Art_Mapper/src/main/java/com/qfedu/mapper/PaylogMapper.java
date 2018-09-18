package com.qfedu.mapper;

import com.qfedu.domain.Paylog;

public interface PaylogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paylog record);

    int insertSelective(Paylog record);

    Paylog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paylog record);

    int updateByPrimaryKey(Paylog record);
}