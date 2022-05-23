package com.tx.service;

import com.tx.pojo.Topic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
public interface ITopicService  {

    List<Topic> findAllTopic();

}
