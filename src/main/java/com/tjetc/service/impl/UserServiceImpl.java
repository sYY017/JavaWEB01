package com.tjetc.service.impl;

import com.tjetc.dao.UserDao;
import com.tjetc.dao.impl.UserDaoImpl;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao;

    public UserServiceImpl() {
        this.dao = new UserDaoImpl();
    }

    @Override
    public User login(String userName, String pwd) {
        return dao.getUserByNameAndPwd(userName, pwd);
    }
}
