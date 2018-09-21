package com.qfedu.mapper;

import com.qfedu.domain.Special;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Special record);

    int insertSelective(Special record);

    Special selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Special record);

    int updateByPrimaryKeyWithBLOBs(Special record);

    int updateByPrimaryKey(Special record);

    List<Special> querylastest(@Param("index")int index, @Param("count")int count);
    int selectCount();

}