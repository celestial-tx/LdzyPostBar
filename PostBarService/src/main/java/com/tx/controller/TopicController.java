package com.tx.controller;


import com.tx.pojo.Topic;
import com.tx.service.impl.TopicServiceImpl;
import com.tx.utils.ResultCode;
import com.tx.utils.Result;
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
    public Result findById(@PathVariable int id){
        Topic topic = topicService.findById(id);
        Integer code = topic != null? ResultCode.GET_SUCCESS.getCode() : ResultCode.GET_ERR.getCode();
        String msg = topic != null? "" : ResultCode.GET_ERR.getMessage();
        return new Result(topic,code,msg);
    }

    // 根据类型，时间查询逆序分页查询帖子
    @GetMapping("/type")
    public Result findAllByType( String topic_type, int pageNumber ,int pageSize){
        List<Topic> topicList = topicService.findAllByType(topic_type, pageNumber, pageSize);
        return new Result(topicList, topicList == null? ResultCode.GET_ERR.getCode() : ResultCode.GET_SUCCESS.getCode()
                         ,topicList == null? ResultCode.GET_ERR.getMessage() : ResultCode.GET_SUCCESS.getMessage());
    }


    // 根据时间逆序分页查询帖子
    @GetMapping("/params")
    public Result findPageByTime(int pageNumber ,int pageSize){
        List<Topic> topicList = topicService.findPageByTime(pageNumber, pageSize);
        return new Result(topicList, topicList == null? ResultCode.GET_ERR.getCode() : ResultCode.GET_SUCCESS.getCode()
                          ,topicList == null? ResultCode.GET_ERR.getMessage() : ResultCode.GET_SUCCESS.getMessage());
    }

}

