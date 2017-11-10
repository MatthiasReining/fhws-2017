
package com.fhws.javaee.presentation.showcase.servlets;

import com.fhws.javaee.ComplexCalculation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("complex")
public class ComplexCalculationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ComplexCalculation cc = new ComplexCalculation();
        double value = cc.calc(3.0);
        
        response.getWriter().append("complex calculation... result " + value);
    }

}
