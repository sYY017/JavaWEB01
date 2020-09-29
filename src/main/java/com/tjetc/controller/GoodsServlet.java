package com.tjetc.controller;

import com.tjetc.domain.Goods;
import com.tjetc.service.GoodsService;
import com.tjetc.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "goodsServlet", urlPatterns = "/good", initParams = {
        @WebInitParam(name = "character", value = "UTF-8")
})
/*添加一个支持文件上传的注解*/
@MultipartConfig
public class GoodsServlet extends HttpServlet {
    private GoodsService service = new GoodsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码方式
        req.getCharacterEncoding();
        resp.getCharacterEncoding();

        String op = req.getParameter("op");
        if ("add".equals(op)) {
            this.add(req, resp);
        } else if ("show".equals(op)) {
            try {
                this.show(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Goods> list=service.selectAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("showGoods.jsp").forward(req,resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("goodsName");
        double price = Double.parseDouble(req.getParameter("price"));
        //获取图片part对象
        Part part = req.getPart("image");
        //获取提交图片名称
        String oldName = part.getSubmittedFileName();
        //给图片起一个新名字
        String newName = "/" + UUID.randomUUID().toString().replace("-", "").toUpperCase()
                + oldName.substring(oldName.lastIndexOf("."));
        //找到一个存储图片的文件夹  获取项目运行的本地路径  项目的部署路径
        String path = this.getServletContext().getRealPath("/image");
        //System.out.println(this.getServletContext().getContextPath()); //输出:/JavaWEB01_Web_exploded
        //System.out.println(path);
        //创建File对象
        File file = new File(path);
        //判断文件是否存在
        if (!file.exists()) {
            //创建文件夹
            file.mkdir();
        }
        //利用part接口上传图片到本地文件夹
        part.write(path+newName);
        String s=service.addGoods(new Goods(1,name,"/image"+newName,price));
        req.setAttribute("message",s);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
