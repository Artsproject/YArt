package com.qfedu.controller;


import com.qfedu.common.result.R;
import com.qfedu.common.vo.CartItemVo;
import com.qfedu.domain.CartItem;
import com.qfedu.domain.User;
import com.qfedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/20 0020
 */

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("cartadd.do")
    @ResponseBody
    public R cartAdd(CartItem cartItem, HttpServletRequest request) {

        // TODO 这里调用用户接口获取用户ID
        boolean addOk = cartService.addItem(cartItem, 1);

        R r = null;

        if (addOk) {
            r = R.setOK();
        } else {
            r = R.setERROR();
        }

        return r;
    }

    @RequestMapping(value = "cartitems.do", method = RequestMethod.GET)
    @ResponseBody
    public R cartItems(HttpServletRequest request) {
        // TODO 这里调用用户接口获取用户ID
        User user = new User();
        user.setId(1);

        if (user != null) {
            List<CartItemVo> itemVos = cartService.queryItemsByUid(user.getId());

            R r = R.setOK();
            r.setData(itemVos);

            return r;
        }

        return R.setERROR();
    }

    // TODO CRUD 操作是否需要提供登录用户的ID？安全操作
    @RequestMapping("cartdel.do")
    @ResponseBody
    public R cartItemDelete(Integer itemId) {
        if (itemId != null) {
            if (cartService.deleteItemByItemId(itemId)) {
                return R.setOK();
            }
        }
        return R.setERROR();
    }

    @RequestMapping("cartcheck.do")
    @ResponseBody
    public R cartCheck(Integer workId, Integer printNo) {
        R r = cartService.checkExists(workId, printNo);
        return r;
    }

}
