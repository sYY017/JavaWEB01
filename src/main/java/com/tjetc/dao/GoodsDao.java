package com.tjetc.dao;

import com.tjetc.domain.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    //添加商品
    int addGoods(Goods good);

    //显示所有商品
    List<Goods> selectAll() throws SQLException;
}
