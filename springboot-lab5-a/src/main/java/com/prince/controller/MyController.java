package com.prince.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.model.StudentDAO;


@RestController
@RequestMapping("/api")
public class MyController 
{	
	StudentDAO DAO = new StudentDAO();
	
	@GetMapping("/student")
	public String getStudent()
	{
		return DAO.readStudent().toString();
	}
	
	@GetMapping("/marks")
	public String getMarks()
	{
		return DAO.readMarks().toString();
	}
}
