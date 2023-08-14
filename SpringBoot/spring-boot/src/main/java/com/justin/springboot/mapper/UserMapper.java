package com.justin.springboot.mapper;

import com.justin.springboot.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();

    User getUserByID(int id);

    void addUser(User user);
}
