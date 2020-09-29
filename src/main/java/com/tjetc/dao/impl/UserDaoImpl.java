package com.tjetc.dao.impl;

import com.tjetc.dao.UserDao;
import com.tjetc.domain.User;
import com.tjetc.util.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByNameAndPwd(String userName, String pwd) {
        String sql="select * from user where username=? and password=?";
        ResultSet rs=DBTools.exQuery(sql,userName,pwd);
        User user=new User();
        try {
            if(rs.next()){
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(rs.getString(4));
                user.setEmail(rs.getString(5));
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            //关闭连接
            DBTools.closeConnection();
        }
    }
}
