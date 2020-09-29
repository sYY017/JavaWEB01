package com.tjetc.dao.impl;

import com.tjetc.dao.EmpDao;
import com.tjetc.domain.Emp;
import com.tjetc.util.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    public Emp getEmpByNameAndPost(String empName, int postType) {
        try {
            String sql="select * from employee where post_type=? and emp_name=?";
            ResultSet rs=DBTools.exQuery(sql,postType,empName);
            Emp emp=new Emp();
            if(rs.next()){
                emp.setId(rs.getInt(1));
                emp.setPostType(rs.getInt(2));
                emp.setEmpName(rs.getString(3));
                emp.setEmpSex(rs.getInt(4));
                emp.setEmpAge(rs.getInt(5));
                emp.setEmpDepart(rs.getString(6));
                emp.setEmpYear(rs.getInt(7));
            }
            //关闭连接
            DBTools.closeConnection();
            return emp;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<Emp> getAllPost() {
        try {
            String sql="SELECT DISTINCT post_type from employee";
            ResultSet rs=DBTools.exQuery(sql);
            List<Emp> emps=new ArrayList<Emp>();
            while (rs.next()){
                Emp emp=new Emp();
                emp.setPostType(rs.getInt("post_type"));
                emps.add(emp);
            }
            //关闭连接
            DBTools.closeConnection();
            return emps;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<Emp> getEmpLike(String keywords) {
        try {
            String sql="select * from employee where emp_name like ?";
            ResultSet rs=DBTools.exQuery(sql,'%'+keywords+'%');
            List<Emp> list=new ArrayList<Emp>();
            while (rs.next()){
                Emp emp=new Emp();
                emp.setId(rs.getInt(1));
                emp.setPostType(rs.getInt(2));
                emp.setEmpName(rs.getString(3));
                emp.setEmpSex(rs.getInt(4));
                emp.setEmpAge(rs.getInt(5));
                emp.setEmpDepart(rs.getString(6));
                emp.setEmpYear(rs.getInt(7));
                list.add(emp);
            }
            //关闭连接
            DBTools.closeConnection();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
