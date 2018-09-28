package com.qfedu.controller;

import com.qfedu.common.result.R;
import com.qfedu.common.vo.CartItemVo;
import com.qfedu.common.vo.OrderVo;
import com.qfedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/27 0027 17:29
 */

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;


    /**
     * 订单预览
     * 费用条目总计的计算在后台。
     * @param cartItemId
     * @return
     */
    @RequestMapping("orderpreview.do")
    @ResponseBody
    public R orderPreview(Integer[] cartItemId) {//前端传入参数为购物车中选中的cartItemId，格式为get/post传递参数格式（id=1&id=2..）
        R r = null;

        List<CartItemVo> cartItemVos = cartService.queryItemsByItemIds(cartItemId);

        OrderVo<CartItemVo> orderVo = new OrderVo<CartItemVo>();
        // 这里将购物车详情设定到订单预览项，供前端展示
        orderVo.setItems(cartItemVos);

        int framePrice = 0, transPrice = 0;
        for (CartItemVo item : cartItemVos) {
            framePrice += item.getFramePrice();
            transPrice += item.getTransPrice();
        }

        orderVo.setFramePrice(framePrice);
        orderVo.setTransPrice(transPrice);
        orderVo.setTotalPrice(framePrice + transPrice);

        r = R.setOK();
        r.setData(orderVo);

        return r;
    }


    /**
     * 提交订单，简化数据：只存储作品和收货地址
     * @param cartItemId
     * @param addressId
     * @param request
     * @return
     */
    @RequestMapping(value = "orderadd.do", method = RequestMethod.POST)
    @ResponseBody
    public R orderAdd(List<Integer> cartItemId, Integer addressId, HttpServletRequest request) {


        return null;
    }



}
