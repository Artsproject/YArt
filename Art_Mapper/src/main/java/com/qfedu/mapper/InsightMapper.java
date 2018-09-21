package com.qfedu.mapper;

import com.qfedu.domain.Insight;

import java.util.List;

public interface InsightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insight record);

    int insertSelective(Insight record);

    Insight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Insight record);

    int updateByPrimaryKey(Insight record);

    List<Insight> queryHomepage();


    List<Insight> queryForDetail(int id);
}