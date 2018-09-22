package com.qfedu.controller;

import com.qfedu.common.result.R;
import com.qfedu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者：lienzhao
 * 时间：2018/9/22 0022 11:59
 */

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;


}
