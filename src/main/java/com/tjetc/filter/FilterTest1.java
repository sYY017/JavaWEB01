package com.tjetc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "filtertest",urlPatterns = "/*",initParams = {
        @WebInitParam(name = "character",value = "UTF-8")
})
public class FilterTest1 implements Filter {

    private String character;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器的初始化方法");
        character=filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器的doFilter方法");
        //设置请求对象、响应对象的编码方式
        servletRequest.setCharacterEncoding(character);
        servletResponse.setCharacterEncoding(character);
        //过滤完以后放行通过
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器的销毁方法");
    }
}
