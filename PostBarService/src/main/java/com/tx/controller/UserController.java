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

    @PostMapping("/register")
    public Result saveUser(@PathVariable  User user){
        System.out.println("1231");
        int i = userService.saveUser(user);
        return new Result(i > 0? ResultCode.POST_SUCCESS.getCode(): ResultCode.POST_ERR.getCode()
                          ,i > 0? ResultCode.POST_SUCCESS.getMessage(): ResultCode.POST_ERR.getMessage());
    }

    @PostMapping("/login")
    public Result login(Integer account , String passwd){
        System.out.println(account+passwd);
        boolean login = userService.login(account, passwd);
        return new Result(login ? ResultCode.POST_SUCCESS.getCode() : ResultCode.POST_ERR.getCode(),login ? "登录成功" : "用户名或密码不正确");
    }

}

