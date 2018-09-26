package com.qfedu.controller;

import com.qfedu.common.result.R;
import com.qfedu.domain.City;
import com.qfedu.domain.County;
import com.qfedu.domain.Province;
import com.qfedu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/22 0022 11:59
 */

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;


    @RequestMapping("provinces.do")
    @ResponseBody
    public R provinces() {

        List<Province> provinces = provinceService.queryProvince();
        R r = R.setOK();
        r.setData(provinces);
        return r;
    }

    @RequestMapping("cities.do")
    @ResponseBody
    public R cities(Integer provinceId) {

        R r = null;
        if (provinceId != null) {
            List<City> cities = provinceService.queryCityByProvinceId(provinceId);
            r = R.setOK();
            r.setData(cities);
        } else {
            r = R.setERROR();
            r.setMsg("need provinceId");
        }
        return r;
    }

    @RequestMapping("counties.do")
    @ResponseBody
    public R counties(Integer cityId) {
        R r = null;
        if (cityId != null) {
            List<County> provinces = provinceService.queryCountyByCityId(cityId);
            r = R.setOK();
            r.setData(provinces);
        } else {
            r = R.setERROR();
            r.setMsg("need cityId");
        }
        return r;
    }

}
