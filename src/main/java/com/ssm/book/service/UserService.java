package com.ssm.book.service;


import com.ssm.book.pojo.User;

public interface UserService {

    User checkUser(String uname, String pwd);
}
