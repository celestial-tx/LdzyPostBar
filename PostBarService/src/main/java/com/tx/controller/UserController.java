package com.tx.controller;


import com.tx.pojo.User;
import com.tx.service.impl.UserServiceImpl;
import com.tx.utils.Result;
import com.tx.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // 注册
    @PostMapping("/register")
    public Result saveUser(String uname,int account , String passwd){
        int i = userService.saveUser(uname,account,passwd);
        return new Result(i > 0? ResultCode.POST_SUCCESS.getCode(): ResultCode.POST_ERR.getCode()
                          ,i > 0? ResultCode.POST_SUCCESS.getMessage(): ResultCode.POST_ERR.getMessage());
    }

    // 登录
    @PostMapping("/login")
    public Result<Long> login(int account , String passwd){
        System.out.println(account+passwd);
        boolean login = userService.login(account, passwd);
        Long uid = null;
        if (login){
            uid = userService.getUid(account);
        }
        Result<Long> result=new Result<Long>(uid,login ? ResultCode.POST_SUCCESS.getCode() : ResultCode.POST_ERR.getCode(),login ? "登录成功" : "用户名或密码不正确");
        return result;

    }

    @GetMapping("/{uid}")
    public Result findByAccount(@PathVariable Long uid){
        List<User> userList = userService.findTopic(uid);
        return new Result(userList,userList == null? ResultCode.GET_ERR.getCode() : ResultCode.GET_SUCCESS.getCode()
                      ,userList == null? ResultCode.GET_ERR.getMessage() : ResultCode.GET_SUCCESS.getMessage());
    }
}

