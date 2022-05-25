package com.tx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tx.TiebaApplication;
import com.tx.dao.TopicDao;
import com.tx.dao.UserDao;
import com.tx.pojo.Topic;
import com.tx.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TiebaApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TopicDao topicDao;

    @Test
    void contextLoads() {
//        LambdaQueryWrapper<Topic> lambdaQueryWrapper = new LambdaQueryWrapper();
//        lambdaQueryWrapper.eq(Topic::getFromUid,1528650303208017922L);
//        List<Topic> list = topicDao.selectList(lambdaQueryWrapper);
//        System.out.println(list);
       int pageNumber = 0;
       int pageSize = 3;
        QueryWrapper<Topic> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time_topic");
        long count=topicDao.selectCount(wrapper);
        IPage<Topic> page = new Page<>(pageNumber,pageSize,count);//参数一：当前页，参数二：每页记录数
        //这里想加分页条件的可以如方法三自己构造条件构造器
        IPage<Topic> userIPage = topicDao.selectPage(page, wrapper);
        System.out.println("总页数： "+userIPage.getPages());
        System.out.println("总记录数： "+userIPage.getTotal());
        userIPage.getRecords().forEach(System.out::println);

    }

}
