package com.tjetc.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTools {
    private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String user = "root";
    private static final String password = "123456";

    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    //获取连接
    public static Connection getConnection() {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    //增删改操作
    public static int exUpdate(String sql, Object... object) {
        conn = DBTools.getConnection();
        int n = 0;
        try {
            //创建预编译对象
            pstmt = conn.prepareStatement(sql);
            if (object != null) {
                for (int i = 0; i < object.length; i++) {
                    //给参数赋值
                    pstmt.setObject(i + 1, object[i]);
                }
            }
            //执行sql
            n = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //关闭连接
        closeConnection();
        return n;
    }

    //查询操作
    public static ResultSet exQuery(String sql, Object... params) {
        conn = DBTools.getConnection(); 
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    //关闭连接
    public static void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
