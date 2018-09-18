package com.qfedu.service;

import com.qfedu.common.vo.Recommendvo;

import java.util.List;

public interface WorkService {
    List<Recommendvo> querycommend(String type);
}
