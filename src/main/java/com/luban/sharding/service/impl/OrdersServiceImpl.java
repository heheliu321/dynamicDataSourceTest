package com.luban.sharding.service.impl;

import com.luban.sharding.entity.User;
import com.luban.sharding.mapper.OrdersMapper;
import com.luban.sharding.mapper.UserMapper;
import com.luban.sharding.service.OrdersService;
import com.luban.sharding.service.UserService;
import com.luban.sharding.utils.DbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    UserService userService;


    @Override
    public Integer insertOrders(User user) {
        Integer integer = userService.insertUser(user);
        Integer integer1 = ordersMapper.insertOrders(user);
//        int i=1/0;
        return integer1+10;
    }
}
