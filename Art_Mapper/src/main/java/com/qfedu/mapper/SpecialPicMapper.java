package com.qfedu.mapper;

import com.qfedu.domain.SpecialPic;

public interface SpecialPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecialPic record);

    int insertSelective(SpecialPic record);

    SpecialPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecialPic record);

    int updateByPrimaryKey(SpecialPic record);
}