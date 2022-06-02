package com.tx.utils;

public class Result {
    //描述统一格式中的数据
    private Object data;
    //描述统一格式中的编码，用于区分操作
    private Integer code;
    //描述统一格式中的消息
    private String msg;

    public Result(){}

    public Result(Integer code,Object data){}

    public Result(Integer code,Object data,String msg){}


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
