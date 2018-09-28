package com.qfedu.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.redis.JedisUtil;
import com.qfedu.common.result.PageVo;
import com.qfedu.common.util.EncrypUtil;
import com.qfedu.common.vo.ArtistWorkvo;
import com.qfedu.common.vo.Recommendvo;
import com.qfedu.common.vo.WorkItemvo;

import com.qfedu.mapper.WorkItemMapper;
import com.qfedu.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkItemMapper mapper;

    @Autowired
    private JedisUtil util;

    @Override
    public List<Recommendvo> querycommend(String type) {

        List<Recommendvo> list = mapper.querycommend(type);
        if (list != null) {

            String token = EncrypUtil.md5Pass(list.toString());
            System.out.println(token);
            util.addStr(token,JSON.toJSONString(list));
        }

        return list;
    }

    @Override
    public PageVo<Recommendvo> queryByPage(int page, int count) {
        int index = 0;
        if(page > 0){
            index=(page-1)*count;
        }
        PageVo<Recommendvo> pageVo = PageVo.createPage(mapper.qeurylastest(index, count), mapper.selectCount());
        if (pageVo != null) {
            pageVo.setCode(0);
            pageVo.setMsg("查询成功");
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("查询失败");
        }
        return pageVo;
    }

    @Override
    public List<Recommendvo> queryAllarea(Recommendvo revo) {
        return mapper.queryAllarea(revo);
    }

    @Override
    public WorkItemvo selectByWid(Integer id) {
        return mapper.selectByWid(id);
    }



    @Override
    public ArtistWorkvo selectArtworkByWid(Integer id) {
        int uid = mapper.selectUidByWorkid(id);
        if (uid != 0) {
            ArtistWorkvo avo = mapper.selectArtworkByWid(uid);
            return avo;
        } else {
            return null;
        }
    }
}
