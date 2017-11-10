package com.fhws.javaee.presentation.showcase.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("FirstServlet")
public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>First Servlet</h1>");
			out.println("</body>");
			out.println("</html>");
		}
		
	}
	
	

}
