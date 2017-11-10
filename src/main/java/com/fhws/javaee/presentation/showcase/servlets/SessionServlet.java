package com.fhws.javaee.presentation.showcase.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int count = 0;
		HttpSession session = request.getSession();
		Object countObj= session.getAttribute("counter");
		if (countObj != null) 
			count = (int) countObj;
		
		count++;
		
		session.setAttribute("counter", count);
		
		response.getWriter().append("SessionId: " + session.getId() + "   - Counter: " + count);
		
	}
}
