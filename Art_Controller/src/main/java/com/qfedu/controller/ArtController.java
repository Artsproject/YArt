package com.qfedu.controller;

import com.qfedu.common.result.PageVo;
import com.qfedu.common.result.R;
import com.qfedu.domain.Analyse;
import com.qfedu.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArtController {
    @Autowired
    private ArtService service;

    //艺术家---更多艺术家展示接口
    @RequestMapping("artists.do")
    @ResponseBody
    public PageVo artists() {
        List list = service.queryartists();
        PageVo pageVo = new PageVo();
        if (list.size() == 0) {
            pageVo.setMsg("当前列表为空");
            pageVo.setCode(1);
            return pageVo;
        } else {
            pageVo.setData(list);
            pageVo.setMsg("成功");
            pageVo.setCode(1);
            return pageVo;
        }
    }
    //推荐作品艺术评析接口
    @RequestMapping("analyse.do")
    @ResponseBody
    public R analyse(int wid) {
        Analyse analyse = service.selectBywid(wid);
        System.out.println(analyse);
        if (analyse != null) {
          return new R(0,"成功",analyse);
        } else {
            return new R(1,"失败",null);
        }
    }
}
