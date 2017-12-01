package com.fhws.javaee.presentation.showcase.ejb;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("ejb")
public class EjbTestServlet extends HttpServlet {
    
    //@EJB
    //ComplexCalculationBeanLocal cc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //float result = cc.calc(123);
        resp.getWriter().println("im ejb servlet");
        //resp.getWriter().println("result: " + result);
        
    }
    
    
}
