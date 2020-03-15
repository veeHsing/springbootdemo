package com.zhangwx.service;

import com.zhangwx.model.User;

public interface UserService {

    public User findById(Integer id);

    public User update(User user);

    public void delete(Integer id);

    public void test(User user);
}
