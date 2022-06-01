package com.tx.controller;


import com.alibaba.fastjson.JSON;
import com.tx.pojo.Topic;
import com.tx.service.impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tx
 * @since 2022-05-23
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicServiceImpl topicService;

    // 根据id查询帖子
    @GetMapping("/byId/{id}")
    public Topic findById(@PathVariable int id){
        return  topicService.findById(id);
    }

    // 根据类型，时间查询逆序分页查询帖子
    @GetMapping("/type")
    public List<Topic> findAllByType( String topic_type, int pageNumber ,int pageSize){
        return  topicService.findAllByType(topic_type,pageNumber,pageSize);
    }


    // 根据时间逆序分页查询帖子
    @GetMapping("/params")
    public List<Topic> findPageByTime(int pageNumber ,int pageSize){
        return  topicService.findPageByTime(pageNumber, pageSize);
    }

}

