package com.qfedu.controller;

import com.qfedu.common.result.PageVo;
import com.qfedu.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpecialController {
    @Autowired
    private SpecialService service;

    //首页专题show接口
    @RequestMapping("showspecial.do")
    @ResponseBody
    public PageVo querylastest(int page, int limit) {
        return service.queryByPage(page, limit);
    }



}
