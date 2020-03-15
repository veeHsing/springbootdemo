package com.zhangwx.controller;

import com.zhangwx.model.User;
import com.zhangwx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

@Controller
@Validated
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(Model model){
        model.addAttribute("username","zhangwx");
        jdbcTemplate.execute("select  * from  user ");
        return "login";
    }

    @RequestMapping("test")
    public String test(Model model){
        model.addAttribute("username","zhangwx");
        return "test";
    }

    @RequestMapping("user")
    @ResponseBody
    public User getUser(@Validated User user1){
        User user = userService.findById(1);
        System.out.println(user);
        return user;
    }
}
