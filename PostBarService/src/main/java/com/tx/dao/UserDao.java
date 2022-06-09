package com.tx.dao;

import com.tx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Results(value = {
            @Result(property = "uid",column = "uid"),
            @Result(property = "uname",column = "uname"),
            @Result(property = "user_account",column = "userAccount"),
            @Result(property = "user_passwd",column = "userPasswd"),
            @Result(property = "create_time",column = "createTime"),
            @Result(property = "topicList", javaType= List.class, column = "uid",
                    many = @Many(select = "com.tx.dao.TopicDao.findByUid"))
    })
    @Select("select * from table_user where uid = #{uid}")
    List<User> findTopic(Long uid);
}
