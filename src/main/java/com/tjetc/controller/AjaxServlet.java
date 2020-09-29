package com.tjetc.controller;

import com.google.gson.Gson;
import com.tjetc.domain.Emp;
import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="ajaxServlet",urlPatterns = "/ajax")
public class AjaxServlet extends HttpServlet {
    private EmpService service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getCharacterEncoding();
        resp.getCharacterEncoding();

        String op = req.getParameter("op");
        if ("jiao".equals(op)) {
            String username = req.getParameter("username");
            if (username != null) {
                List<Emp> list = service.getEmpLike(username);
                if (list.size() != 0) {
                    PrintWriter pw = resp.getWriter();
                    pw.write("***此用户已存在");
                    pw.flush();
                } else {
                    PrintWriter pw = resp.getWriter();
                    pw.write("***可以注册,此用户不存在");
                    pw.flush();
                }
            }
        } else if ("like".equals(op)) {
            String keywords = req.getParameter("keywords");
            // System.out.println(keywords);
            if (keywords != null) {
                List<Emp> emps = service.getEmpLike(keywords);
                //System.out.println(emps);
                //获取输出流
                Gson gson = new Gson();
                //将集合转换成json字符串格式
                String json = gson.toJson(emps);
                PrintWriter out = resp.getWriter();
                out.write(json);
                out.flush();
            }
        } else if ("gettest".equals(op)) {
            PrintWriter out = resp.getWriter();
            out.write("get请求");
            out.flush();
        }
    }
}
