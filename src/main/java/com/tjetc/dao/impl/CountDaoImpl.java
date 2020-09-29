package com.tjetc.dao.impl;

import com.tjetc.dao.CountDao;
import com.tjetc.domain.Count;
import com.tjetc.util.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountDaoImpl implements CountDao {
    @Override
    public Count count() {
        String sql = "select num from count";
        ResultSet rs = DBTools.exQuery(sql);
        Count count = new Count();
        try {
            if (rs.next()) {
                count.setNum(rs.getInt(1));
            }
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            //关闭连接
            DBTools.closeConnection();
        }
    }
}
