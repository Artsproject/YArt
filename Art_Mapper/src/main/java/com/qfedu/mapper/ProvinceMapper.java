package com.qfedu.mapper;

import com.qfedu.common.vo.CityVo;
import com.qfedu.common.vo.ProvinceVo;
import com.qfedu.domain.Province;

import java.util.List;

public interface ProvinceMapper {

    List<Province> select();

    List<ProvinceVo> selectFull();
}