package com.qfedu.mapper;

import com.qfedu.domain.Insightpic;

public interface InsightpicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insightpic record);

    int insertSelective(Insightpic record);

    Insightpic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Insightpic record);

    int updateByPrimaryKey(Insightpic record);
}