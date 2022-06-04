package com.tx.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // 增加成功
     POST_SUCCESS(20001,"增加成功"),
    // 增加失败
     POST_ERR(40401,"增加失败"),

    // 删除成功
     DELETE_SUCCESS(20002,"删除成功"),
    // 删除失败
     DELETE_ERR(40402,"删除失败"),

    // 修改成功
     PUT_SUCCESS(20003,"修改成功"),
    // 修改失败
     PUT_ERR(40403,"修改失败"),

    // 查询成功
     GET_SUCCESS(20004,"查询成功"),
    // 查询失败
     GET_ERR(40404,"查询失败"),

    // 系统未知异常
     SYSTEM_UNKNOW_ERR(59999,"系统未知异常");

    private final Integer code;
    private final String message;

}
