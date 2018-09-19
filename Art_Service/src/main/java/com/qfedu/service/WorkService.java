package com.qfedu.service;

import com.qfedu.common.result.PageVo;
import com.qfedu.common.vo.Recommendvo;

import java.util.List;

public interface WorkService {
    List<Recommendvo> querycommend(String type);

    PageVo<Recommendvo> queryByPage(int page, int count);

    List<Recommendvo> queryAllarea(Recommendvo revo);

}
