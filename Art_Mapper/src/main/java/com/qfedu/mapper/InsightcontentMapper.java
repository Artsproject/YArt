package com.qfedu.mapper;

import com.qfedu.domain.Insightcontent;

public interface InsightcontentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insightcontent record);

    int insertSelective(Insightcontent record);

    Insightcontent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Insightcontent record);

    int updateByPrimaryKeyWithBLOBs(Insightcontent record);

    int updateByPrimaryKey(Insightcontent record);
}