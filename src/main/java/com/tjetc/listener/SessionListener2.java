package com.tjetc.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("SessionListener2")
public class SessionListener2 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("创建一个session对象");
        HttpSession session =httpSessionEvent.getSession();
        //设置最大的会话时间限制
        session.setMaxInactiveInterval(10);//单位为秒
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("销毁一个session对象");
    }
}
