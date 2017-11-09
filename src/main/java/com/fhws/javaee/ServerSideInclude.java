package com.fhws.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("ssi")
public class ServerSideInclude extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		out.println("<h1>Server Side Include</h1>");

		request.getRequestDispatcher("/SecondServlet").include(request, response);

		out.println("<hr>immer noch im ssi servlet");

	}
}
