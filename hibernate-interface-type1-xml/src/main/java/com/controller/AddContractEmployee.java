package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.ContractEmployee;
import com.model.EmployeeManager;


@WebServlet("/AddContractEmployee")
public class AddContractEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("t1");
		double payperhour = Double.parseDouble(request.getParameter("t2"));
		String contract = request.getParameter("t3");
		ContractEmployee e = new ContractEmployee();
		e.setName(name);
		e.setContractduration(contract);
		e.setPayperhour(payperhour);
		
		
		
		EmployeeManager em = new EmployeeManager();
		String ack = em.insertContractEmployee(e);
		pw.print(ack);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
