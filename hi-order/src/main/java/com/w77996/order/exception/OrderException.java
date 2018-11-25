package com.w77996.order.exception;


import com.w77996.order.enums.ResultEnum;

/**
 * 订单异常
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String msg){
        super(msg);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
