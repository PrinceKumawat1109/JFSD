package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.EmployeeManager;
import com.model.RegularEmployee;


@WebServlet("/AddRegularEmployee")
public class AddRegularEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("t1");
		double salary = Double.parseDouble(request.getParameter("t2"));
		double bonus = Double.parseDouble(request.getParameter("t3"));
		RegularEmployee e = new RegularEmployee();
		e.setName(name);
		e.setSalary(salary);
		e.setBonus(bonus);
		
		
		EmployeeManager em = new EmployeeManager();
		String ack = em.insertRegularEmployee(e);
		pw.print(ack);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
