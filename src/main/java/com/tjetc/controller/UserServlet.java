package com.tjetc.controller;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "userServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        req.getCharacterEncoding();
        resp.getCharacterEncoding();

        String op = req.getParameter("op");
        if ("login".equals(op)) {
            this.login(req, resp);
        } else if ("reset".equals(op)) {
            this.reset(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        //System.out.println(username);
        String password = req.getParameter("pwd");
        String token = req.getParameter("token");
        //System.out.println(token);
        String token2 = (String) req.getSession().getAttribute("key");
        //System.out.println(token2);

        if (username != null && password != null && token != null && token2 != null && token.equals(token2)) {
            //清空sesssion 防止表单重复提交
            req.getSession().removeAttribute("key");
            //System.out.println(req.getSession().getAttribute("key"));

            User user = service.login(username, password);
            if (user.getUserName() != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user.getUserName());
                session.setAttribute("role", user.getRole());
                //只要登录成功就证明有人登录了，需要把登录的人数记录到全局变量ServletContext对象中
                int num = Integer.parseInt(String.valueOf(this.getServletContext().getAttribute("num")));
                //将数值+1 再存储到全局变量中
                this.getServletContext().setAttribute("num", num + 1);
                try {
                    req.getRequestDispatcher("login2.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                req.setAttribute("message", "登录失败!");
                try {
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            //表单重复提交
            req.setAttribute("message", "表单不可重复提交!");
            try {
                req.getRequestDispatcher("login2.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void reset(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        req.setAttribute("message", "注销成功,请重新登录");
        try {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
