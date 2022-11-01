package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.StudentManager;

@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try
		{
			int sid = Integer.parseInt(request.getParameter("t1"));
			StudentManager SM = new StudentManager();
			String ack = SM.deleteData(sid);
			pw.print(ack);
		}catch(Exception e)
		{
			pw.print(e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
