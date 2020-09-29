package com.tjetc.service;

import com.tjetc.domain.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    //添加商品
    String addGoods(Goods good);

    //显示所有商品
    List<Goods> selectAll() throws SQLException;
}
