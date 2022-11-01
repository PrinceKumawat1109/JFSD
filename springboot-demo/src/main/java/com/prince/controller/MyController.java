package com.prince.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.entity.Student;
import com.prince.model.StudentDAO;

@RestController
@RequestMapping("/api")
public class MyController 
{
	@GetMapping("/students/{id}")
	public String getData(@PathVariable("id") int id)
	{
		StudentDAO DAO = new StudentDAO();
		return DAO.getById(id).toString();
	}
	
	@GetMapping("/students")
	public String getAll(Student S)
	{
		StudentDAO DAO = new StudentDAO();
		return DAO.readData().toString();
	}
	
	
	@PostMapping("/students")
	public String postDetails(@RequestBody Student S)
	{
		StudentDAO DAO = new StudentDAO();
		return DAO.insertData(S);
	}
	
	
	@PutMapping("/students")
	private String putDetails()
	{
		return "Response from PUT service";
	}
	
	
	@PutMapping("/updatestudents")
	private String updateData(@RequestBody Student S)
	{
		StudentDAO DAO = new StudentDAO();
		return DAO.updateData(S);
	}
	
	
	@DeleteMapping("/students")
	public String deleteDetails()
	{
		return "Response from DELETE service";
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteDetails(@PathVariable("id") int id)
	{
	    StudentDAO DAO = new StudentDAO();
	    return DAO.deleteData(id);
	}
}
