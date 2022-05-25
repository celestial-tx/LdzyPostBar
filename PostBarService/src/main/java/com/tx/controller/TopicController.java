package com.tx.controller;


import com.tx.pojo.Topic;
import com.tx.service.impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<Topic> findAll(){
        return topicService.findAllTopic();
    }

}

