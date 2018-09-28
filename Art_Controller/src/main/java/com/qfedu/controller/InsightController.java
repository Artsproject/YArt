package com.qfedu.controller;

import com.qfedu.common.result.PageVo;
import com.qfedu.domain.Insight;
import com.qfedu.service.InsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InsightController {
    @Autowired
    private InsightService service;

    @RequestMapping("insight.do")
    @ResponseBody
    public PageVo queryHomepage() {
        List<Insight> list = service.queryHomepage();
        PageVo pageVo = new PageVo();
        if (list.size() == 0) {
            pageVo.setCode(1);
            pageVo.setMsg("当前列表为空");
        } else {
            pageVo.setData(list);
            pageVo.setCode(0);
            pageVo.setMsg("成功");
        }
        return pageVo;
    }

    @RequestMapping("insightdetail.do")
    @ResponseBody
    public PageVo queryonesight(int id) {
        List list = service.queryForDetail(id);
        PageVo pageVo = new PageVo();
        if (list.size() == 0) {
            pageVo.setCode(1);
            pageVo.setMsg("当前列表为空");
        } else {
            pageVo.setData(list);
            pageVo.setCode(0);
            pageVo.setMsg("成功");
        }
        return pageVo;
    }
}
