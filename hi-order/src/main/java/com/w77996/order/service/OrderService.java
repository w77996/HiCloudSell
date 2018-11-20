package com.w77996.order.service;


import com.w77996.order.dto.OrderDTO;

/**
 * Created by 廖师兄
 * 2017-12-10 16:39
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
