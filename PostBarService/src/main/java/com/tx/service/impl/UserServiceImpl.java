package com.tx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tx.exception.BusinessException;
import com.tx.pojo.User;
import com.tx.dao.UserDao;
import com.tx.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tx.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@Service
public class UserServiceImpl  implements IUserService {

    @Autowired
    private UserDao userDao;

    // 注册
    @Override
    public int saveUser(String uname,int account , String passwd) {
        try {
            User user = new User();
            user.setUname(uname);
            user.setUserAccount(account);
            user.setUserPasswd(passwd);
            int insert = userDao.insert(user);
            return insert;
        } catch (Exception e) {
            throw new BusinessException(ResultCode.POST_ERR.getCode(), ResultCode.POST_ERR.getMessage());
        }

    }

    // 登录
    @Override
    public boolean login(int account, String passwd) {
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("user_account", account);
            User user = userDao.selectOne(wrapper);
            if (user == null) {
                return false;
            }
            if (user.getUserPasswd().equals(passwd)) {
                return true;
            }
        } catch (Exception e) {
            throw new BusinessException(ResultCode.GET_SUCCESS.getCode(), "数据库异常");
        }
          return false;
    }

    // 查询用户信息
    @Override
    public User findByAccount(int account) {
        try{
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("account",account);
            User user = userDao.selectOne(wrapper);
            return user;
        }catch (Exception e){
            throw new BusinessException(ResultCode.GET_ERR.getCode(),ResultCode.GET_ERR.getMessage());
        }
    }
}
