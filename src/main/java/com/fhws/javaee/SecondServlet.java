package com.fhws.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("SecondServlet")
public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Time Servlet</h1>");
			out.println("Server time: " + new Date());
			out.println("<br>");
			
			Calendar now = Calendar.getInstance();
			if (now.get(Calendar.HOUR_OF_DAY) < 12)
				out.println("Good Morning");
			else 
				out.println("Good Afternoon");
			
			
			out.println("</body>");
			out.println("</html>");
		}
		
	}
	
	

}
