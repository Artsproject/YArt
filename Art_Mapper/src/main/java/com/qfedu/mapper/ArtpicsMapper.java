package com.qfedu.mapper;

import com.qfedu.common.vo.Analysevo;
import com.qfedu.domain.Artpics;

public interface ArtpicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Artpics record);

    int insertSelective(Artpics record);

    Artpics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Artpics record);

    int updateByPrimaryKey(Artpics record);


}