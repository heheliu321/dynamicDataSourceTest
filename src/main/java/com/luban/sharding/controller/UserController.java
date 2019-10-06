package com.luban.sharding.controller;

import com.luban.sharding.entity.User;
import com.luban.sharding.service.UserService;
import com.luban.sharding.utils.DbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService orderService;


    @GetMapping("/insertUser")
    public Integer insertUser(User user){
        return orderService.insertUser(user);
    }


    @GetMapping("/selectUser")
    public List<User> selectUser(){
        List<User> users = orderService.selectUser();
        return users;
    }


}
