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

        Integer[] nos = soldWorkMapper.selectPrintNosByWorkId(workId);

        System.out.println(Arrays.asList(nos));

        return nos;
    }


    /**
     * “随机”获取一个可售版号
     * @param workId
     * @return 如果是多版，返回大于0的整数，如果是独版，返回0
     */
    @Override
    public int randomGetByWorkId(Integer workId) {

        Integer[] soldNos = soldWorkMapper.selectPrintNosByWorkId(workId);

        int count = soldWorkMapper.selectPrintCountByWorkId(workId);

        // 版数大于1表示多版
        if (count > 1) {
            List<Integer> integerList = Arrays.asList(soldNos);

            for (int i = 1; i <= count; i++) {
                if (!integerList.contains(i)) {
                    return i;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean addOneSold(Integer workId, Integer printNo) {
        return soldWorkMapper.insert(workId, printNo) > 0;
    }
}
