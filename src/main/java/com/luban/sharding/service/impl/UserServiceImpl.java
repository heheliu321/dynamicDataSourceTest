package com.luban.sharding.service.impl;

import com.luban.sharding.entity.User;
import com.luban.sharding.mapper.UserMapper;
import com.luban.sharding.service.UserService;
import com.luban.sharding.utils.DbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }
}
