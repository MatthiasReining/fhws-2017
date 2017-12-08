package com.fhws.javaee.presentation.showcase.cdi;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("cdi4")
public class CDIServlet4 extends HttpServlet {

    @Inject
    Payload payload;

    @Inject
    EJBSingleton ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sessionId = req.getSession(true).getId();
        if (payload.getData() == null) {
            payload.setData(sessionId);
        }
        ejb.exec();
        resp.getWriter().println(payload);

    }

}
