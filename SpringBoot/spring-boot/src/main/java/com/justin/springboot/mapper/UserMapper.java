package com.justin.springboot.mapper;

import com.justin.springboot.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();

    User getUserByID(int id);

    void addUser(User user);

    @Select("select * from [user] where name = #{name}")
    User getUserByName(String name);
}
