package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/CalculatorService")
public class CalculatorService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		
		BufferedReader br = request.getReader();
		String jsonData = br.readLine();
		
		ExtractData data = fromJSONString(jsonData);
		data.SUM = data.A + data.B;
		data.SUB = data.A - data.B;
		
		jsonData = toJSONString(data);
		
		pw.print(jsonData);
	}
	
	public ExtractData fromJSONString(String jsonData)
	{
		GsonBuilder gbuilder = new GsonBuilder();
		Gson gson = gbuilder.create();
		ExtractData data = gson.fromJson(jsonData, ExtractData.class);
		return data;		
	}
	
	public String toJSONString(ExtractData data)
	{
		GsonBuilder gbuilder = new GsonBuilder();
		Gson gson = gbuilder.create();
		return gson.toJson(data);
	}
			
}
