package com.w77996.zuul.enums;

public enum ResultStatus{

    REQUEST_TOO_MUCH(500100, "请求太频繁");

    private String msg;
    private Integer code;

    ResultStatus(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
