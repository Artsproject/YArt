package com.qfedu.mapper;

import com.qfedu.domain.City;

import java.util.List;

public interface CityMapper {


    List<City> selectByProvinceId(Integer provinceId);

}