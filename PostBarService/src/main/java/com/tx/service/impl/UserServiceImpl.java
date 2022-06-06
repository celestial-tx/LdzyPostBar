package com.tx.service.impl;

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

    @Override
    public int saveUser(User user) {
        try {
            int insert = userDao.insert(user);
            return insert;
        }catch (Exception e){
            throw new BusinessException(ResultCode.PUT_ERR.getCode(), ResultCode.PUT_ERR.getMessage());
        }

    }
}
