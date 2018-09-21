package com.qfedu.service.impl;

import com.qfedu.common.result.PageVo;
import com.qfedu.domain.Special;
import com.qfedu.mapper.SpecialMapper;
import com.qfedu.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    private SpecialMapper mapper;

    @Override
    public PageVo<Special> queryByPage(int page, int count) {
        int index = 0;
        if(page > 0){
            index=(page-1)*count;
        }

        PageVo<Special> pageVo = PageVo.createPage(mapper.querylastest(index, count), mapper.selectCount());

        if (pageVo != null) {
            pageVo.setCode(0);
            pageVo.setMsg("查询成功");
            return pageVo;
        } else {
            pageVo.setCode(1);
            pageVo.setMsg("查询失败");
            return pageVo;
        }

    }
}
