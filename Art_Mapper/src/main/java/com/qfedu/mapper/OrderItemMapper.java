package com.qfedu.mapper;

import com.qfedu.common.vo.OrderItemVo;
import com.qfedu.domain.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    List<OrderItemVo> selectByOrderId(Integer orderId);

    int insert(OrderItem record);

}