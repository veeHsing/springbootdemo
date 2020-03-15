package com.zhangwx.dao;

import com.zhangwx.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id= #{id}")
    public User findById(Integer id);
}
