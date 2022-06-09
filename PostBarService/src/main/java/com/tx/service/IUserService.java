package com.tx.service;

import com.tx.pojo.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
public interface IUserService {

    int saveUser(String uname,int account , String passwd);

    boolean login(int account, String passwd);

    User findByAccount(int account);

    Long getUid(int account);

    List<User> findTopic(Long uid);

}
