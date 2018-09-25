package com.qfedu.service.impl;

import com.alibaba.fastjson.JSON;
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

    private Boolean preloaded;

    // TODO 在应用启动时（APPListener）将省市县全部数据预加载到redis中存储
    @Override
    public void setPreloadInRedis(boolean preload) {

        // 将省事县数据预加载到redis中存储
        if (preload) {
            if (preloaded == null || !preloaded.booleanValue()) {
                preloaded = preload;

                List<ProvinceVo> provinceVos = provinceMapper.selectFull();

                boolean setOk = redisUtil.set("provinceFull", JSON.toJSONString(provinceVos));
            }
        }
    }

    // TODO 从redis中获取省市县全部数据的JSON格式字符串
    @Override
    public String getFullFromRedis() {

        String jsonStr = "";
        if (preloaded.booleanValue() && redisUtil.hasKey("provinceFull")) {
            jsonStr = (String) redisUtil.get("provinceFull");
        }

        return jsonStr;
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
