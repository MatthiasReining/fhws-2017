package com.fhws.javaee.presentation.showcase.cdi;

import com.fhws.javaee.presentation.showcase.ejb.*;
import com.fhws.javaee.business.log.entity.JPALog;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("cdi")
public class CDIServlet extends HttpServlet {

    @Inject
    Message message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        message.setMessage("hello world");
      
        message.print( resp.getWriter());

    }

}
