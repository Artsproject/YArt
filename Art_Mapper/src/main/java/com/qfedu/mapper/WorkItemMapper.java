package com.qfedu.mapper;

import com.qfedu.common.vo.Analysevo;
import com.qfedu.common.vo.ArtistWorkvo;
import com.qfedu.common.vo.Recommendvo;
import com.qfedu.common.vo.WorkItemvo;
import com.qfedu.domain.WorkItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkItem record);

    int insertSelective(WorkItem record);

    int updateByPrimaryKeySelective(WorkItem record);

    int updateByPrimaryKey(WorkItem record);

    List<Recommendvo> querycommend(String type);

    List<Recommendvo> qeurylastest(@Param("index")int index, @Param("count")int count);
    int selectCount();

    List<Recommendvo> queryAllarea(Recommendvo revo);

    WorkItemvo selectByWid(Integer id);

    int selectUidByWorkid(Integer id);


    ArtistWorkvo selectArtworkByWid(Integer uid);

}