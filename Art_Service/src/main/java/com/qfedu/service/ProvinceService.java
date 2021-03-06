package com.qfedu.service;

import com.qfedu.domain.City;
import com.qfedu.domain.County;
import com.qfedu.domain.Province;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/22 0022 10:16
 */
public interface ProvinceService {

    void setPreloadInRedis(boolean preload);

    /**
     * 从redis中获取所有省市县的JSON格式字符串
     * @return
     */
    String getFullFromRedis();

    List<Province> queryProvince();

    List<City> queryCityByProvinceId(Integer provinceId);

    List<County> queryCountyByCityId(Integer cityId);

}
