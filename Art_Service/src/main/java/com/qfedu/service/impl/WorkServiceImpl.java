package com.qfedu.service.impl;

import com.qfedu.common.result.PageVo;
import com.qfedu.common.result.R;
import com.qfedu.common.vo.Analysevo;
import com.qfedu.common.vo.ArtistWorkvo;
import com.qfedu.common.vo.Recommendvo;
import com.qfedu.common.vo.WorkItemvo;
import com.qfedu.domain.WorkItem;
import com.qfedu.mapper.AnalyseMapper;
import com.qfedu.mapper.WorkItemMapper;
import com.qfedu.mapper.WorkMapper;
import com.qfedu.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkItemMapper mapper;

    @Override
    public List<Recommendvo> querycommend(String type) {
        List<Recommendvo> list = mapper.querycommend(type);

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
