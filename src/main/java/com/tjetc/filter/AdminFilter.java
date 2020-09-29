package com.tjetc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "adminFilter", urlPatterns = "/admin/*", initParams = {
        @WebInitParam(name = "character", value = "UTF-8")
})
public class AdminFilter implements Filter {
    private String character;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化方法");
        //获取web.xml配置中的初始化编码参数
        character = filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getCharacterEncoding();
        servletResponse.getCharacterEncoding();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String a = (String) session.getAttribute("role");
        if ("admin".equals(a)) {
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.setAttribute("message", "对不起访问失败,您不是管理员");
            request.getRequestDispatcher("../login.jsp").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁方法");
    }
}
