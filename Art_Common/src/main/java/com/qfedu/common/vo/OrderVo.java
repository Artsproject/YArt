package com.qfedu.common.vo;

import com.qfedu.domain.Cart;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/27 0027 20:52
 */
public class OrderVo<T> {

    // 订单费用总计
    private Integer totalPrice;
    // 运输费用总计
    private Integer transPrice;
    // 装裱费用总计
    private Integer framePrice;
    // 活动优惠
    // 艺网码优惠
    // 优惠券


    private List<T> items;

    public OrderVo() {
    }


    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTransPrice() {
        return transPrice;
    }

    public void setTransPrice(Integer transPrice) {
        this.transPrice = transPrice;
    }

    public Integer getFramePrice() {
        return framePrice;
    }

    public void setFramePrice(Integer framePrice) {
        this.framePrice = framePrice;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
