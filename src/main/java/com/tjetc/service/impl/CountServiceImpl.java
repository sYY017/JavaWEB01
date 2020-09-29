package com.tjetc.service.impl;

import com.tjetc.dao.CountDao;
import com.tjetc.dao.impl.CountDaoImpl;
import com.tjetc.domain.Count;
import com.tjetc.service.CountService;

public class CountServiceImpl implements CountService {
    private CountDao dao = new CountDaoImpl();

    @Override
    public Count count() {
        return dao.count();
    }
}
