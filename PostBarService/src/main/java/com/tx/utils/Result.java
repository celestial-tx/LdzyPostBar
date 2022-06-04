package com.tx.utils;

import lombok.Data;

@Data
public class Result<T> {
    //描述统一格式中的数据
    private T data;
    //描述统一格式中的编码，用于区分操作
    private Integer code;
    //描述统一格式中的消息
    private String message;


    public Result() {
    }

    public Result(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public Result( Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
