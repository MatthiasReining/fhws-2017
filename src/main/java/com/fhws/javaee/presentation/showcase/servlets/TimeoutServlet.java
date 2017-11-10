package com.fhws.javaee.presentation.showcase.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TimeoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int count = 0;
        HttpSession session = request.getSession();
        Object countObj = session.getAttribute("counter");
        if (countObj != null) {
            count = (int) countObj;
        }
        count++;
        session.setAttribute("counter", count);

        response.getWriter().append("SessionId: " + session.getId() + "   - Counter: " + count);
    }

}
