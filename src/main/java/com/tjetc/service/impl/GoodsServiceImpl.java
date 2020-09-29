package com.tjetc.service.impl;

import com.tjetc.dao.GoodsDao;
import com.tjetc.dao.impl.GoodsDaoImpl;
import com.tjetc.domain.Goods;
import com.tjetc.service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao=new GoodsDaoImpl();
    @Override
    public String addGoods(Goods good) {
        return dao.addGoods(good)>0?"添加成功":"添加失败";
    }

    @Override
    public List<Goods> selectAll() throws SQLException {
        return dao.selectAll();
    }
}
