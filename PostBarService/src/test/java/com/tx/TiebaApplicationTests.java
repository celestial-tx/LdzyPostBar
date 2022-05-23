package com.tx;

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

    }

}
