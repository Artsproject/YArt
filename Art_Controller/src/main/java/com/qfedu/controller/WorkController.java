package com.qfedu.controller;

import com.qfedu.common.result.PageVo;
import com.qfedu.common.vo.Recommendvo;
import com.qfedu.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WorkController {
    @Autowired
    private WorkService service;

    @RequestMapping("showcommend.do")
    @ResponseBody
    public PageVo querycommend(String type) {
        List<Recommendvo> list = service.querycommend(type);
        PageVo pageVo = new PageVo();
        if (list.size() != 0) {
            pageVo.setCode(0);
            pageVo.setMsg("查询成功");
            pageVo.setData(list);
            return pageVo;
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("当前类型暂无");
            return pageVo;
        }
    }
}
