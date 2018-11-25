package com.w77996.order.service;


import com.w77996.order.dto.OrderDTO;


public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单 ( 只能卖家操作 )
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
