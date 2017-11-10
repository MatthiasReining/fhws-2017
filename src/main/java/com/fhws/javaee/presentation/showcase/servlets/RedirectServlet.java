package com.fhws.javaee.presentation.showcase.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/error")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int calc = 42/0;
		
		response.getWriter().append("Hello FHWS");
		
	}

}
