package com.qfedu.service.impl;

import com.qfedu.common.vo.CartItemVo;
import com.qfedu.domain.Cart;
import com.qfedu.domain.CartItem;
import com.qfedu.mapper.CartItemMapper;
import com.qfedu.mapper.CartMapper;
import com.qfedu.service.CartService;
import com.qfedu.service.SoldWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/19 0019
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartItemMapper itemMapper;

    @Autowired
    private SoldWorkService soldWorkService;


    // TODO 简化了需求接口：请求添加时，如果是独版作品才做该检查，非独版作品只提供随机版号，不需要检查。
    /**
     *
     * 检查同一作品是否已存在购物车中
     *
     *
     * @param workId
     * @param printNo
     * @return
     */
    @Override
    public boolean checkExists(Integer workId, Integer printNo) {

        // 版号信息可为空，Mapper通过动态sql查寻
        // 版号为空，假定作品为独版
        if (itemMapper.selectCountByWorkIdAndPrintNo(workId, printNo) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据用户ID获取购物车信息，信息只包括：购物车ID和创建时间，不包含Item信息
     * @param uid
     * @return
     */
    @Override
    public Cart queryCartByUid(Integer uid) {
        return cartMapper.selectByUid(uid);
    }


    /**
     *
     * @param uid
     * @return
     */
    @Override
    public List<CartItemVo> queryItemsByArtistUid(Integer uid) {

        List<CartItemVo> itemVos = cartMapper.selectItemsByArtistUid(uid);

        return itemVos;
    }

    /**
     * 将作品加入购物车，cartItem需要设定购物车ID(cartId)，如果没有设定，需要提供当前用户ID(uid)。
     * @param cartItem
     * @param uid 如果cartItem中没有设定cartId的话，需要提供用户ID
     * @return
     */
    @Override
    public boolean addItem(CartItem cartItem, Integer uid) {

        // 确认购物车id，如果无法获取，返回false
        if (uid != null) {
            Cart cart = cartMapper.selectByUid(uid);
            cartItem.setCid(cart.getId());
        }
        if (cartItem.getCid() == null) {
            return false;
        }


        // 确认版号，如果没有提供版号，则随机获取一个版号
        if (cartItem.getPrintNo() == null) {

            // 方法返回可能是0或大于0的整数，等于0表是独版
            int printNo = soldWorkService.randomGetByWorkId(cartItem.getWid());

            cartItem.setPrintNo(printNo);
        }

        int row = itemMapper.insert(cartItem);

        return row > 0;
    }

    @Override
    public boolean deleteItemByItemId(Integer itemId) {
        return itemMapper.deleteByPrimaryKey(itemId) > 0;
    }
}
