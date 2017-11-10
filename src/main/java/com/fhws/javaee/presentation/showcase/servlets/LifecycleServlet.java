/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.presentation.showcase.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LifecycleServlet", urlPatterns = {"/ls"})
public class LifecycleServlet extends HttpServlet {
    
    //Diese Variable wird über alle Threads, die auf die Servlet Intanz zugreifen geteilt
    //Sollte man so nicht machen!
    private int var1 = 0;

    @Override
    public void init() throws ServletException {
        super.init();         
        System.out.println("Servlet wird instanziert");
    }

    @Override
    public void destroy() {
        super.destroy(); 
        System.out.println("Servlet wird zerstört");
    }    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var1++;
        try (PrintWriter out = response.getWriter()) {            
            out.println("servlet variable var1: " + var1);          
        }
    }


}
