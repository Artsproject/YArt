package com.qfedu.mapper;

import com.qfedu.common.vo.AddressVo;
import com.qfedu.domain.Recaddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecaddressMapper {

    List<AddressVo> selectByUserId(Integer userId);

    int updateOrdByPrimaryKey(@Param("id") Integer id, @Param("ord") Integer ord);

    /**
     * 获取用户默认地址ID
     * ord等于1，代表默认地址
     * @param uid
     * @return
     */
    Integer selectDefaultIdByUid(Integer uid);

    int deleteByIdAndUid(@Param("id") Integer id, @Param("uid") Integer uid);

    int insert(Recaddress record);

    Recaddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Recaddress record);
}