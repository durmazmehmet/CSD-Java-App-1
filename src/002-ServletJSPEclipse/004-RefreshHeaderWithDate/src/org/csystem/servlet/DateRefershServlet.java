package org.csystem.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DateRefershServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		LocalDateTime now = LocalDateTime.now();
		
		res.setIntHeader("refresh", 1);		
		res.getWriter().printf("%02d/%02d/%04d %02d:%02d:%02d", 
				now.getDayOfMonth(), now.getMonthValue(), now.getYear(), now.getHour(), now.getMinute(), now.getSecond());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doGet(req, res);
	}

}
