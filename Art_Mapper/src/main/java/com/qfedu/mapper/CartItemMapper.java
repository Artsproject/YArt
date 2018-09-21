package com.qfedu.mapper;

import com.qfedu.domain.CartItem;

public interface CartItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CartItem record);


}