package com.qfedu.controller;

import com.qfedu.common.result.PageVo;
import com.qfedu.common.result.R;
import com.qfedu.common.util.CookieUtil;
import com.qfedu.common.vo.ArtistWorkvo;
import com.qfedu.common.vo.Recommendvo;
import com.qfedu.common.vo.WorkItemvo;
import com.qfedu.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    private WorkService service;

    //首页分类查看推荐作品接口
    @RequestMapping("showcommend.do")
    @ResponseBody
    public PageVo querycommend(String type, HttpServletResponse response, HttpServletRequest request) {
        List<Recommendvo> list = service.querycommend(type);
        PageVo pageVo = new PageVo();
        if (list.size() != 0) {
            CookieUtil.setCK(response,"recommend",list.toString());
            pageVo.setCode(0);
            pageVo.setMsg("查询成功");
            pageVo.setData(list);
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("当前类型暂无");
        }
        return pageVo;

    }

    //首页查看最新作品接口
    @RequestMapping("lastest.do")
    @ResponseBody
    public PageVo<Recommendvo> queryBypage(int page, int limit) {
      return service.queryByPage(page, limit);
    }

    //首页条件查询作品接口
    @RequestMapping("querygo.do")
    @ResponseBody
    public PageVo queryAllarea(Recommendvo revo) {
        List<Recommendvo> list = service.queryAllarea(revo);
        PageVo pageVo = new PageVo();
        if (list.size() != 0) {
            pageVo.setData(list);
            pageVo.setCode(0);
            pageVo.setMsg("查询成功");
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("暂无该作品");
        }
        return pageVo;
    }

    //推荐作品详情展示
    @RequestMapping("recommenddetail.do")
    @ResponseBody
    public R commenddetail(int wid) {
        WorkItemvo item = service.selectByWid(wid);
        if (item != null) {
            return new R(0,"成功",item);
        } else {
            return new R(1,"失败",null);
        }
    }

    //推荐作品相关艺术家展示接口
    @RequestMapping("artistdetail.do")
    @ResponseBody
    public R artistdetail(int id) {
        ArtistWorkvo avo = service.selectArtworkByWid(id);
        if (avo != null) {
            return new R(0,"成功",avo);
        } else {
            return new R(1,"失败",null);
        }
    }


}
