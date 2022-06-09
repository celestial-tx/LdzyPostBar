package com.tx.dao;

import com.tx.pojo.Topic;
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
public interface TopicDao extends BaseMapper<Topic> {

    @Results(value = {
            @Result(property = "tid", column = "tid"),
            @Result(property = "topic_type", column = "topicType"),
            @Result(property = "content", column = "content"),
            @Result(property = "from_uid", column = "uid"),
            @Result(property = "create_time_topic", column = "createTimeTopic"),
            @Result(property = "from_name", column = "fromName")
    })
    @Select("select * from table_topic where from_uid = #{uid}")
    List<Topic> findByUid(Long uid);

}
