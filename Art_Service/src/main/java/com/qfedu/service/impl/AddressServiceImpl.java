package com.qfedu.service.impl;

import com.qfedu.common.vo.AddressVo;
import com.qfedu.domain.Recaddress;
import com.qfedu.mapper.RecaddressMapper;
import com.qfedu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 作者：lienzhao
 * 时间：2018/9/25 0025 12:07
 */

@Service
public class AddressServiceImpl implements AddressService {

    private final RecaddressMapper recaddressMapper;

    @Autowired
    public AddressServiceImpl(RecaddressMapper recaddressMapper) {
        this.recaddressMapper = recaddressMapper;
    }

    @Override
    public List<AddressVo> queryList(Integer uid) {
        return recaddressMapper.selectByUserId(uid);
    }

    @Override
    public boolean save(Recaddress recaddress, Integer uid) {

        // 添加默认地址
        // ord为1代表默认地址， 大于1代表非默认
        if (recaddress.getOrd() != null && recaddress.getOrd() == 1) {
            Integer defaultId = recaddressMapper.selectDefaultIdByUid(uid);
            if (defaultId != null) {
                recaddressMapper.updateOrdByPrimaryKey(defaultId, 2);
            }
        } else {
            recaddress.setOrd(2);
        }

        recaddress.setUid(uid);

        return recaddressMapper.insert(recaddress) > 0;
    }

    @Override
    public boolean update(Recaddress recaddress, Integer uid) {

        if (recaddress.getOrd() != null && recaddress.getOrd() == 1) {
            Integer defaultId = recaddressMapper.selectDefaultIdByUid(uid);
            if (defaultId != null && !Objects.equals(defaultId, recaddress.getId())) {
                recaddressMapper.updateOrdByPrimaryKey(defaultId, 2);
            }
        } else {
            recaddress.setOrd(2);
        }

        return recaddressMapper.updateByPrimaryKey(recaddress) > 0;
    }

    @Override
    public boolean setDefault(Integer id, Integer uid) {

        Integer defaultId = recaddressMapper.selectDefaultIdByUid(uid);
        if (Objects.equals(id, defaultId)) {
            return true;
        } else if (defaultId != null) {
            // 将之前的默认地址设为非默认
            recaddressMapper.updateOrdByPrimaryKey(defaultId, 2);
        }

        return recaddressMapper.updateOrdByPrimaryKey(id, 1) > 0;
    }

    @Override
    public boolean delete(Integer id, Integer uid) {
        return recaddressMapper.deleteByIdAndUid(id, uid) > 0;
    }
}
