package com.qfedu.mapper;

import com.qfedu.domain.WorkItem;

public interface WorkItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkItem record);

    int insertSelective(WorkItem record);

    WorkItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkItem record);

    int updateByPrimaryKey(WorkItem record);
}