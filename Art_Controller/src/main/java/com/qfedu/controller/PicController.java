package com.qfedu.controller;

import com.qfedu.common.result.PageVo;
import com.qfedu.domain.Pic;
import com.qfedu.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PicController {

    @Autowired
    private PicService service;

    @RequestMapping("lunboshow.do")
    @ResponseBody
    public PageVo lunboshow() {
        List<Pic> pics = service.showFor();
        PageVo pageVo = new PageVo();
        if (pics.size() != 0) {
            pageVo.setData(pics);
            pageVo.setCode(0);
            pageVo.setMsg("查询成功");
            return pageVo;
        } else {
            pageVo.setMsg("空空如也");
            pageVo.setCode(1);
            return pageVo;
        }
    }
}
