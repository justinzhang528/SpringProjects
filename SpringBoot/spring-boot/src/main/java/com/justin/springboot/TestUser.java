package com.justin.springboot;


import com.justin.springboot.mapper.UserMapper;
import com.justin.springboot.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUser {

    @Test
    public void testUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User newUser = new User(7,"tom",26,"Phd");
        userMapper.addUser(newUser);

        List<User> users = userMapper.getAllUser();
        System.out.println(users);

        sqlSession.close();
    }
}
