package com.tjetc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginfilter",urlPatterns = "/login2.jsp",initParams = {
        @WebInitParam(name = "character",value = "UTF-8")
})
public class LoginFilter implements Filter {

    private String character;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化方法");
        //获取web.xml配置中的初始化编码参数
        character = filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //设置全局的编码方式
        servletRequest.setCharacterEncoding(character);
        servletResponse.setCharacterEncoding(character);


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //通过request对象获取session
        HttpSession session = request.getSession();
        //获取session中的数据
        Object u = session.getAttribute("user");
        if (u == null) {
            request.setAttribute("message", "对不起请先登录!");
            request.getRequestDispatcher("login.jsp").forward(request, servletResponse);
        }
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁方法");
    }
}
