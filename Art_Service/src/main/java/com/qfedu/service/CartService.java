package com.qfedu.service;

import com.qfedu.common.vo.CartItemVo;
import com.qfedu.domain.Cart;
import com.qfedu.domain.CartItem;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/18 0018
 */
public interface CartService {

    /**
     *
     * 检查同一作品是否已存在购物车中
     * @param workId
     * @param printNo
     * @return
     */
    boolean checkExists(Integer workId, Integer printNo);

    Cart queryCartByUid(Integer uid);

    List<CartItemVo> queryItemsByArtistUid(Integer uid);

    boolean addItem(CartItem cartItem, Integer uid);

    boolean deleteItemByItemId(Integer itemId);

}
