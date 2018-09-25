package com.qfedu.service;

import com.qfedu.common.vo.AddressVo;
import com.qfedu.domain.Recaddress;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/25 0025 10:41
 */
public interface AddressService {

    List<AddressVo> queryList(Integer uid);

    // 新增地址
    boolean save(Recaddress recaddress, Integer uid);

    // 修改地址
    boolean update(Recaddress recaddress, Integer uid);

    // 设定默认
    boolean setDefault(Integer id, Integer uid);

    // 删除地址
    boolean delete(Integer id, Integer uid);


}
