package com.luban.sharding.controller;

import com.luban.sharding.entity.User;
import com.luban.sharding.service.OrdersService;
import com.luban.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    OrdersService orderService;


    @GetMapping("/insertOrder")
    public Integer insertUser(User user){
        return orderService.insertOrders(user);
    }

}
