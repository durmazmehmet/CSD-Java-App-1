package org.cystem.formprocessing.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cystem.formprocessing.entity.PersonInfo;


@WebServlet("/personform")
public class PersonFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().println("Access forbidden");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		
		
		try {
			String name = req.getParameter("name");
			
			if (name == null)
				throw new IllegalArgumentException("Illegal access for name");
			
			String citizenId = req.getParameter("citizen_id");
			int age = Integer.parseInt(req.getParameter("age"));
			
			PersonInfo pi = new PersonInfo(name, citizenId, age);
			
			//...
			
			out.printf("%s", pi);			
		}	
		catch (Throwable ex) {
			out.printf("Exception:%s, Mesage:%s", ex.getClass().getName(), ex.getMessage());
		}	
	}
}
