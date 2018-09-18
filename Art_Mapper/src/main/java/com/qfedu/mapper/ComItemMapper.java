package com.qfedu.mapper;

import com.qfedu.domain.ComItem;

public interface ComItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ComItem record);

    int insertSelective(ComItem record);

    ComItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComItem record);

    int updateByPrimaryKey(ComItem record);
}