package com.tx.service.impl;

import com.tx.pojo.Topic;
import com.tx.dao.TopicDao;
import com.tx.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@Service
public class TopicServiceImpl  implements ITopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> findAllTopic() {
        return topicDao.selectList(null);
    }
}
