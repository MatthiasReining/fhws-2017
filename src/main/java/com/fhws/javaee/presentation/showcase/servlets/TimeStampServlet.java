package com.fhws.javaee.presentation.showcase.servlets;

import com.fhws.javaee.ComplexCalculation;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("jsp-ts")
public class TimeStampServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ComplexCalculation cc = new ComplexCalculation();
        req.setAttribute("fhwsTime", new Date());
        req.setAttribute("complexObj", cc);
        req.getRequestDispatcher("WEB-INF/timestamp.jsp").forward(req, resp);
        
    }
    
    
}
