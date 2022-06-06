package com.tx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tx.exception.BusinessException;
import com.tx.pojo.Topic;
import com.tx.dao.TopicDao;
import com.tx.service.ITopicService;
import com.tx.utils.ResultCode;
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
        try {
            QueryWrapper<Topic> wrapper = new QueryWrapper<>();
            wrapper.orderByDesc("create_time_topic");
            long count=topicDao.selectCount(wrapper);
            IPage<Topic> page = new Page<>(pageNumber,pageSize,count);//参数一：当前页，参数二：每页记录数
            //这里想加分页条件的可以如方法三自己构造条件构造器
            IPage<Topic> userIPage = topicDao.selectPage(page, wrapper);
            return userIPage.getRecords();
        }catch (Exception e){
            throw new BusinessException(ResultCode.GET_ERR.getCode(),"查询失败，数据库异常");
        }

    }

    // 根据id查询
    @Override
    public Topic findById(int id) {
        try {
            return  topicDao.selectById(id);
        }catch (Exception e){
            throw new BusinessException(ResultCode.GET_ERR.getCode(),"查询失败，数据库异常");
        }

    }

    // 根据时间和类型逆序分页查询
    @Override
    public List<Topic> findAllByType(Integer topic_type,int pageNumber, int pageSize) {
        try{
            QueryWrapper<Topic> wrapper = new QueryWrapper<>();
            wrapper.eq("topic_type",topic_type);
            wrapper.orderByDesc("create_time_topic");
            long count=topicDao.selectCount(wrapper);
            IPage<Topic> page = new Page<>(pageNumber,pageSize,count);//参数一：当前页，参数二：每页记录数
            //这里想加分页条件的可以如方法三自己构造条件构造器
            IPage<Topic> topicTypePage = topicDao.selectPage(page, wrapper);
            return topicTypePage.getRecords();
        }catch (Exception e){
            throw new BusinessException(ResultCode.GET_ERR.getCode(),"查询失败，数据库异常");
        }

    }

    @Override
    public int saveTopic(Topic topic) {
        try {
            int insert = topicDao.insert(topic);
            return insert;
        }catch (Exception e){
            throw new BusinessException(ResultCode.PUT_ERR.getCode(), ResultCode.POST_ERR.getMessage());
        }
    }
}
