package com.w77996.order.enums;

import lombok.Getter;


@Getter
public enum ResultEnum {

    PARAM_ERROR(500100, "参数错误"),
    CART_EMPTY(500101, "购物车为空"),
    ORDER_NOT_EXIST(500102, "订单不存在"),
    ORDER_STATUS_ERROR(500103, "订单状态错误"),
    ORDER_DETAIL_NOT_EXIST(500104, "订单详情不存在"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
