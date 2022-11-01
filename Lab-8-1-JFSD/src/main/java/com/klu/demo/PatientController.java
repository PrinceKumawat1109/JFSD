package com.klu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PatientController 
{
	@Autowired
	PatientService ps;
	
	@GetMapping("/patient")
	public String getAll()
	{
		return ps.readData().toString();
	}
	
	@PostMapping("/patient")
	public String insertData(@RequestBody Patient p)
	{
		return ps.saveData(p).toString();
	}
	
	@PutMapping("/patient/{id}")
	public String updateDetails(@RequestBody Patient p, @PathVariable("id") Long id)
	{
		return ps.updateData(p, id).toString();
	}
	
	@DeleteMapping("/patient/{id}")
	public String deleteDetails(@PathVariable("id") Long id)
	{
		ps.deleteData(id);
		return "Deleted Successfully...!";
	}
}
