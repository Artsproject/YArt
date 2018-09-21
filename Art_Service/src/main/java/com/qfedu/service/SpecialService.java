package com.qfedu.service;

import com.qfedu.common.result.PageVo;
import com.qfedu.domain.Special;

import java.util.List;

public interface SpecialService {
    PageVo<Special> queryByPage(int page, int count);
}
