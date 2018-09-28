package com.qfedu.service.impl;

import com.qfedu.mapper.SoldWorkMapper;
import com.qfedu.service.SoldWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/20 0020 20:00
 */

@Service
public class SoldWorkServiceImpl implements SoldWorkService {


    @Autowired
    private SoldWorkMapper soldWorkMapper;


    @Override
    public Integer getPrintCountByWorkId(Integer workId) {
        return soldWorkMapper.selectPrintCountByWorkId(workId);
    }

    @Override
    public Integer[] querySoldByWorkId(Integer workId) {

        Integer[] nos = soldWorkMapper.selectPrintNosByWorkIdAndFlag(workId, 1);

        return nos;
    }

    @Override
    public Integer[] queryOnSailByWorkId(Integer workId) {
        return soldWorkMapper.selectPrintNosByWorkIdAndFlag(workId, 0);
    }


    /**
     * “随机”获取一个可售版号
     * @param workId
     * @return 如果没有可售作品，返回null；返回0，表示独版作品版号；返回大于0的整数，表示多版作品版号
     */
    @Override
    public Integer randomGetByWorkId(Integer workId) {

        // flag=0，代表查询未售作品
        // 对于独版作品，数据表t_sortwork保存的作品版号是0（printNo=0）,如果未售，将返回一个元素（0）的Integer数组
        Integer[] onsales = soldWorkMapper.selectPrintNosByWorkIdAndFlag(workId, 0);

        if (onsales != null && onsales.length > 0) {
            return onsales[0];
        }

        return null;
    }

    @Override
    public boolean setOneSold(Integer workId, Integer printNo) {
        return soldWorkMapper.updateFlag(workId, printNo, 1) > 0;
    }
}
