package com.tjetc.dao;

import com.tjetc.domain.Emp;

import java.util.List;

public interface EmpDao {
    //根据员工姓名和职位查询员工信息
    Emp getEmpByNameAndPost(String empName, int postType);

    //查询全部职位
    List<Emp> getAllPost();

    //模糊查询
    List<Emp> getEmpLike(String keywords);
}
