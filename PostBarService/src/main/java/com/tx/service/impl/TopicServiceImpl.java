package com.tx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tx.pojo.Topic;
import com.tx.dao.TopicDao;
import com.tx.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类table_user
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@Service
public class TopicServiceImpl  implements ITopicService {

    @Autowired
    private TopicDao topicDao;


    // 跟据时间逆序分页查询
    @Override
    public List<Topic> findPageByTime(int pageNumber, int pageSize) {
        QueryWrapper<Topic> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time_topic");
        long count=topicDao.selectCount(wrapper);
        IPage<Topic> page = new Page<>(pageNumber,pageSize,count);//参数一：当前页，参数二：每页记录数
        //这里想加分页条件的可以如方法三自己构造条件构造器
        IPage<Topic> userIPage = topicDao.selectPage(page, wrapper);
        return userIPage.getRecords();
    }

    @Override
    public Topic findById(int id) {
        return  topicDao.selectById(id);
    }

    @Override
    public List<Topic> findAllByType(String topic_type,int pageNumber, int pageSize) {
        QueryWrapper<Topic> wrapper = new QueryWrapper<>();
        wrapper.eq("topic_type",topic_type);
        wrapper.orderByDesc("create_time_topic");
        long count=topicDao.selectCount(wrapper);
        IPage<Topic> page = new Page<>(pageNumber,pageSize,count);//参数一：当前页，参数二：每页记录数
        //这里想加分页条件的可以如方法三自己构造条件构造器
        IPage<Topic> topicTypePage = topicDao.selectPage(page, wrapper);
        return topicTypePage.getRecords();
    }
}
