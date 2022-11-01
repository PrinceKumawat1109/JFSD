package com.prince.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.entity.Department;
import com.prince.model.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController 
{
	@Autowired
	DepartmentService deptService;
	@GetMapping("/department")
	public String getAll()
	{
		return deptService.readData().toString();
	}
	
	@PostMapping("/department")
	public String insertData(@RequestBody Department D)
	{
		return deptService.saveData(D).toString();
	}
	
	@PutMapping("/department/{id}")
	public String updateDetails(@RequestBody Department D, @PathVariable("id") Long id)
	{
		return deptService.updateData(D, id).toString();
	}
	
	@DeleteMapping("/department/{id}")
	public String deleteDetails(@PathVariable("id") Long id)
	{
		deptService.deleteData(id);
		return "Data deleted successfully...!";
	}
}
