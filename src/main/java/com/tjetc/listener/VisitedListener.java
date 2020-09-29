package com.tjetc.listener;

import com.tjetc.domain.Count;
import com.tjetc.service.CountService;
import com.tjetc.service.impl.CountServiceImpl;
import com.tjetc.util.DBTools;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("VisitedListener")
public class VisitedListener implements ServletContextListener {
    private CountService service = new CountServiceImpl();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("服务器启动,context对象被创建,执行监听器.....");
        //获取网站的访问人数
        Count count = service.count();
        ServletContext sc = servletContextEvent.getServletContext();
        sc.setAttribute("num", count.getNum());

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("服务器关闭,监听器销毁.....");
        DBTools.exUpdate("update count set num=?", Integer.parseInt(String.valueOf(servletContextEvent.getServletContext().getAttribute("num"))));
    }
}
