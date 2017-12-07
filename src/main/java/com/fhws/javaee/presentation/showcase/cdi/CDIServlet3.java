package com.fhws.javaee.presentation.showcase.cdi;

import com.fhws.javaee.presentation.showcase.ejb.*;
import com.fhws.javaee.business.log.entity.JPALog;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Manual injection example
 *
 * @author matthias
 */
@WebServlet("cdi3")
public class CDIServlet3 extends HttpServlet {

    @Inject
    Instance<Message> messageProducer;

    //@Inject
    //Message message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //message.setMessage("blub");
        System.out.println("in doGET");
        
        Message message = messageProducer.get();
        resp.getWriter().println(message.getMessage());

    }

}
