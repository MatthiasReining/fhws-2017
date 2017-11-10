package com.fhws.javaee.presentation.showcase.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("qp")
public class QueryParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doProcess(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		out.println("IP Addresse: " + request.getLocalAddr());

		out.println("HEADER");

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.println(headerName + ": " + request.getHeader(headerName));
		}
		
		out.println("");
		out.println("parameters: ");
		for (Entry<String, String[]> entry: request.getParameterMap().entrySet()) {
			out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
		}
	}
}
