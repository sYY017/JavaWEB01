package com.tjetc.dao;

import com.tjetc.domain.User;

public interface UserDao {
    User getUserByNameAndPwd(String userName, String pwd);
}
