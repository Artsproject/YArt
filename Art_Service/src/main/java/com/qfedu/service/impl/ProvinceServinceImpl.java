package com.qfedu.service.impl;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.vo.ProvinceVo;
import com.qfedu.domain.City;
import com.qfedu.domain.County;
import com.qfedu.domain.Province;
import com.qfedu.mapper.CityMapper;
import com.qfedu.mapper.CountyMapper;
import com.qfedu.mapper.ProvinceMapper;
import com.qfedu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/22 0022 10:23
 */

@Service
public class ProvinceServinceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CountyMapper countyMapper;

    @Autowired
    private RedisUtil redisUtil;

    private volatile Boolean preloaded;

    @Override
    public void setPreloadInRedis(boolean preload) {

        // 将省事县数据预加载到redis中存储
        if (preload) {
            if (preloaded == null || !preloaded.booleanValue()) {
                preloaded = preload;

                List<ProvinceVo> provinceVos = provinceMapper.selectFull();
                System.out.println("----preloadInRedis");
            }
        }
    }

    @Override
    public List<Province> queryProvince() {
        return provinceMapper.select();
    }

    @Override
    public List<City> queryCityByProvinceId(Integer provinceId) {
        return cityMapper.selectByProvinceId(provinceId);
    }

    @Override
    public List<County> queryCountyByCityId(Integer cityId) {
        return countyMapper.selectByCityId(cityId);
    }
}
