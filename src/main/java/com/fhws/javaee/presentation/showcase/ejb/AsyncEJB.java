package com.fhws.javaee.presentation.showcase.ejb;

import com.fhws.javaee.business.log.entity.JPALog;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("async-ejb")
public class AsyncEJB extends HttpServlet {

    @EJB
    LongRunningTask lrt;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long start = System.currentTimeMillis();
        lrt.run("hello hello");

        long duration = System.currentTimeMillis() - start;
        resp.getWriter().println("async-ejb took " + duration + "ms");

    }

}
