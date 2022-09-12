package com.ssm.book.service.impl;


import com.ssm.book.mapper.UserMapper;
import com.ssm.book.pojo.User;
import com.ssm.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String uname, String pwd) {
        return userMapper.checkUser(uname, pwd);
    }
}
