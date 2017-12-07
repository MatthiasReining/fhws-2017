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

@WebServlet("cdi2")
public class CDIServlet2 extends HttpServlet {

    @Inject
    Message m1;

    @Inject @InjectTest
    Message m2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println(m1.getMessage());
        resp.getWriter().println(m2.getMessage());

        m1.setMessage("blub");

        resp.getWriter().println(m2.getMessage());

    }

}
