package com.fhws.javaee.presentation.showcase.ejb;

import com.fhws.javaee.business.log.entity.JPALog;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("tx")
public class TxServlet extends HttpServlet {
    
    @EJB
    EJBTest1 ejb1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        
        JPALog log = ejb1.m1();
        resp.getWriter().println("log data: " + log);
        
    }
    
    
}
