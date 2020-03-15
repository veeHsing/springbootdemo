package com.zhangwx.service.impl;

import com.zhangwx.dao.UserMapper;
import com.zhangwx.model.User;
import com.zhangwx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //缓存
    @Cacheable(cacheNames = "user",key = "#id",condition = "#id>0",unless = "#result == null")
    @Override
    public User findById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    //更新缓存
    @CachePut(cacheNames = "user",key = "#user.id")
    @Override
    public User update(User user) {
        //todo
        return null;
    }


    //删除缓存，出现异常不会清除
    @CacheEvict(cacheNames = "user",key = "#id")
    @Override
    public void delete(Integer id) {
        //todo
    }



    //复杂缓存操作
    @Caching(
        cacheable = {
            @Cacheable(cacheNames = "user",key = "#user.id",condition = "#id>0",unless = "#result == null")
        },
        put = {
            @CachePut(cacheNames = "user",key = "#user.id")
        }
    )
    @Override
    public void test(User user) {

    }

}
