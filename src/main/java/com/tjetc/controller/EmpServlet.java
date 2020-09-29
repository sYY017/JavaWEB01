package com.tjetc.controller;

import com.tjetc.domain.Emp;
import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "empServlet",urlPatterns = "/emp")
public class EmpServlet extends HttpServlet {
    private EmpService service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码方式
        req.getCharacterEncoding();
        resp.getCharacterEncoding();

        String op=req.getParameter("op");
        if("post".equals(op)){
            this.findAllPost(req,resp);
        }else if("find".equals(op)){
            this.find1(req,resp);
        }
    }

    private void find1(HttpServletRequest req, HttpServletResponse resp) {
        String empName=req.getParameter("empname");
        System.out.println("员工姓名:"+empName);
        int post=Integer.parseInt(req.getParameter("post"));
        if (empName.length()!=0){
            try {
                System.out.println("用户名不为空");
                Emp emp2=service.getEmpByNameAndPost(empName,post);
                req.setAttribute("emp2",emp2);
                req.getRequestDispatcher("manage/show2.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(empName.length()==0){
            try {
                System.out.println("用户名为空");
                List<Emp> emps1=service.getEmpLike("");
                req.setAttribute("emps1",emps1);
                req.getRequestDispatcher("manage/show.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void findAllPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //获取所有的职位名称
            List<Emp> list=service.getAllPost();
            req.setAttribute("list",list);
            //页面转发
            req.getRequestDispatcher("manage/search.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
