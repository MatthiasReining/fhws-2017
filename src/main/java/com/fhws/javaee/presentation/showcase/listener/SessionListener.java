package com.fhws.javaee.presentation.showcase.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session wurde angelegt");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session wurde destroyed");
        HttpSession session = se.getSession();
        Object countObj = session.getAttribute("counter");
        if (countObj != null) {
            System.out.println("Count: " + countObj);
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("attribute added" + event.getName() + "(" + event.getValue() + ")");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("attribute replaced" + event.getName() + "(" + event.getValue() + ")");
    }

}
