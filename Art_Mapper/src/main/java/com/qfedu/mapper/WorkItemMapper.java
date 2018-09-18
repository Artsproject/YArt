package com.qfedu.mapper;

import com.qfedu.common.vo.Recommendvo;
import com.qfedu.domain.WorkItem;

import java.util.List;

public interface WorkItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkItem record);

    int insertSelective(WorkItem record);

    WorkItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkItem record);

    int updateByPrimaryKey(WorkItem record);

    List<Recommendvo> querycommend(String type);
}