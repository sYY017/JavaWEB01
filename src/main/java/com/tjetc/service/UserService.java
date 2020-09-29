package com.tjetc.service;

import com.tjetc.domain.User;

public interface UserService {
    //登录
    User login(String userName, String pwd);
}
