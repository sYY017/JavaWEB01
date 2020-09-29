package com.tjetc.dao.impl;

import com.tjetc.dao.GoodsDao;
import com.tjetc.domain.Goods;
import com.tjetc.util.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public int addGoods(Goods good) {
        String sql = "insert into goods(name,image,price) values(?,?,?)";
        int n = DBTools.exUpdate(sql, good.getName(), good.getImage(), good.getPrice());
        return n;
    }

    @Override
    public List<Goods> selectAll() throws SQLException {
        String sql = "select * from goods";
        ResultSet rs = DBTools.exQuery(sql);
        List<Goods> list = new ArrayList<Goods>();
        while (rs.next()) {
            Goods goods = new Goods();
            goods.setId(rs.getInt("id"));
            goods.setName(rs.getString("name"));
            goods.setImage(rs.getString("image"));
            goods.setPrice(rs.getDouble("price"));
            list.add(goods);
        }
        //关流
        DBTools.closeConnection();
        return list;
    }
}
