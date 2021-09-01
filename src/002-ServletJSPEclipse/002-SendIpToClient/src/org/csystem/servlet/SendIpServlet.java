package org.csystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class SendIpServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		String remoteHost = req.getRemoteHost();
		String localHost = req.getLocalAddr();
		
		out.printf("<h2>Your Ip Address:%s</h2>", remoteHost);		
		out.printf("<h2>Your Local Address:%s</h2>", localHost);
	}
	
}
