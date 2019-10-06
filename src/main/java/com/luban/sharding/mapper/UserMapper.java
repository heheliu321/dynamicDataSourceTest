package com.luban.sharding.mapper;

import com.luban.sharding.annotation.MyDataSource;
import com.luban.sharding.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


    @Insert({"insert into user(id,name) values(#{sid},#{sname})"})
    Integer insertUser(User user);


    @MyDataSource("slave")
    @Select("select id as sid,name as sname from user")
    List<User> selectUser();
}
