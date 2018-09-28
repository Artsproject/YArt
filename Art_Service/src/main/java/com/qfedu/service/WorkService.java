package com.qfedu.service;

import com.qfedu.common.result.PageVo;
import com.qfedu.common.vo.Analysevo;
import com.qfedu.common.vo.ArtistWorkvo;
import com.qfedu.common.vo.Recommendvo;
import com.qfedu.common.vo.WorkItemvo;
import com.qfedu.domain.WorkItem;

import java.util.List;

public interface WorkService {
    List<Recommendvo> querycommend(String type);

    PageVo<Recommendvo> queryByPage(int page, int count);

    List<Recommendvo> queryAllarea(Recommendvo revo);
    //推荐作品详情展示
    WorkItemvo selectByWid(Integer id);


    ArtistWorkvo selectArtworkByWid(Integer id);
}
