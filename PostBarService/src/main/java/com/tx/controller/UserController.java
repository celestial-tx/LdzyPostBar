package com.tx.controller;


import com.sun.org.glassfish.gmbal.ParameterNames;
import com.tx.pojo.User;
import com.tx.service.impl.UserServiceImpl;
import com.tx.utils.Result;
import com.tx.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result login(int account , String passwd){
        System.out.println(account+passwd);
        boolean login = userService.login(account, passwd);
        return new Result(login ? ResultCode.POST_SUCCESS.getCode() : ResultCode.POST_ERR.getCode(),login ? "登录成功" : "用户名或密码不正确");
    }

    @GetMapping("/userAccount")
    public Result findByAccount(int account){
        User user = userService.findByAccount(account);
        return new Result(user,user == null? ResultCode.GET_ERR.getCode() : ResultCode.GET_SUCCESS.getCode()
                      ,user == null? ResultCode.GET_ERR.getMessage() : ResultCode.GET_SUCCESS.getMessage());
    }
}

