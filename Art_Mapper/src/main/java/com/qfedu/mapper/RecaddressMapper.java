package com.qfedu.mapper;

import com.qfedu.domain.Recaddress;

public interface RecaddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recaddress record);

    int insertSelective(Recaddress record);

    Recaddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recaddress record);

    int updateByPrimaryKeyWithBLOBs(Recaddress record);

    int updateByPrimaryKey(Recaddress record);
}