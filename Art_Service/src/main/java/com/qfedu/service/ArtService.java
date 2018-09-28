package com.qfedu.service;

import com.qfedu.common.result.R;
import com.qfedu.common.vo.Analysevo;
import com.qfedu.domain.Analyse;

import java.util.List;

public interface ArtService {
    List queryartists();

    //推荐作品艺术评析接口
    Analyse selectBywid(int wid);
}
