package com.ssm.book.mapper;

import com.ssm.book.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User checkUser(@Param("uname") String uname, @Param("pwd") String pwd);

    User getUserById(@Param("id") Integer id);
}
