package com.zhangwx;

import com.zhangwx.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootdemoApplicationTests {


    @Autowired
    private DataSource dataSource;
    @Autowired
    private RedisTemplate redisTemplate;



    @Test
    void contextLoads() throws SQLException {

        Connection connection = dataSource.getConnection();

        System.out.println(connection);

    }

    @Test
    void test1(){
        User user = new User();
        user.setId(1);
        user.setUsername("zhangwx");
        user.setPassword("12121");
        redisTemplate.opsForValue().set("test",user);
        System.out.println(redisTemplate.opsForValue().get("name"));
//        System.out.println(redisTemplate.opsForValue().get("user::1"));

    }

}
