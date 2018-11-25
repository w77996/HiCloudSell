package com.w77996.zuul.vo;

import lombok.Data;

/**
 * 封装返回结果
 */
@Data
public class ResultVO<T> {

    /**
     * 状态码，正常返回值为0
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /** 具体内容 */
    private T data;

    public ResultVO(){}
}
