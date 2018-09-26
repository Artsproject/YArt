package com.qfedu.mapper;

import com.qfedu.domain.County;

import java.util.List;

public interface CountyMapper {

    List<County> selectByCityId(Integer cityId);

}