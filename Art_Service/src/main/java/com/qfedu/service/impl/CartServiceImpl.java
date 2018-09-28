package com.qfedu.service.impl;

import com.qfedu.common.result.R;
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


    /**
     *
     * 检查同一作品是否已存在购物车中
     *
     * 需要参数作品ID和版号NO，如果是独版，printNo可为null或0
     *
     * @param workId
     * @param printNo
     * @return
     */
    @Override
    public R checkExists(Integer workId, Integer printNo) {

        if (printNo == null || printNo == 0) {
            if (soldWorkService.getPrintCountByWorkId(workId) > 1) {
                R r = R.setERROR();
                r.setMsg("作品为多版，需要提供版号。");
                return r;
            }
            printNo = 0;
        }

        if (itemMapper.selectCountByWorkIdAndPrintNo(workId, printNo) > 0) {
            R r = R.setERROR();
            r.setMsg("作品已经存在购物车中");
            return r;
        }

        return R.setOK();
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
    public List<CartItemVo> queryItemsByUid(Integer uid) {

        List<CartItemVo> itemVos = cartMapper.selectItemsByUid(uid);

        return itemVos;
    }

    @Override
    public List<CartItemVo> queryItemsByItemIds(Integer[] ids) {
        return cartMapper.selectByItemIds(ids);
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


        // 确认版号，如果没有提供版号，默认为独版作品，设printNo=0
        // 添加作品前需要进行checkExists检查
        if (cartItem.getPrintNo() == null) {
            cartItem.setPrintNo(0);
        }

        int row = itemMapper.insert(cartItem);

        return row > 0;
    }

    @Override
    public boolean deleteItemByItemId(Integer itemId) {
        return itemMapper.deleteByPrimaryKey(itemId) > 0;
    }
}
