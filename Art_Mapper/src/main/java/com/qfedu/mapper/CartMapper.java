package com.qfedu.mapper;

import com.qfedu.common.vo.CartItemVo;
import com.qfedu.domain.Cart;

import java.util.List;

public interface CartMapper {

    Cart selectByUid(Integer uid);

    List<CartItemVo> selectItemsByArtistUid(Integer uid);

    CartItemVo selectItemByItemId(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}