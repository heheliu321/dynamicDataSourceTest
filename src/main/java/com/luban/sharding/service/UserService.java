package com.luban.sharding.service;

import com.luban.sharding.entity.User;

import java.util.List;

public interface UserService {
    Integer insertUser(User user);

    List<User> selectUser();
}
