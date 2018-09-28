package com.qfedu.mapper;

import com.qfedu.common.result.PageVo;
import com.qfedu.common.result.R;
import com.qfedu.common.vo.Analysevo;
import com.qfedu.domain.Analyse;

import java.util.List;

public interface AnalyseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Analyse record);

    int insertSelective(Analyse record);

    Analyse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Analyse record);

    int updateByPrimaryKeyWithBLOBs(Analyse record);

    int updateByPrimaryKey(Analyse record);

    Analyse selectBywid(int wid);

}