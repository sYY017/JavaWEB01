package com.tjetc.service.impl;

import com.tjetc.dao.EmpDao;
import com.tjetc.dao.impl.EmpDaoImpl;
import com.tjetc.domain.Emp;
import com.tjetc.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao dao = new EmpDaoImpl();

    public Emp getEmpByNameAndPost(String empName, int postType) {
        return dao.getEmpByNameAndPost(empName, postType);
    }

    public List<Emp> getAllPost() {
        return dao.getAllPost();
    }

    public List<Emp> getEmpLike(String keywords) {
        return dao.getEmpLike(keywords);
    }
}
