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
public class DoctorController 
{
	@Autowired
	DoctorService ds;
	
	@GetMapping("/doctor")
	public String getAll()
	{	
		return ds.readData().toString();
	}
	
	@PostMapping("/doctor")
	public String insertData(@RequestBody Doctor d)
	{
		return ds.saveData(d).toString();
	}
	
	@PutMapping("/doctor/{id}")
	public String updateDetails(@RequestBody Doctor d,@PathVariable("id") Long id)
	{
		return ds.updateData(d, id).toString();
	}
	
	@DeleteMapping("/doctor/{id}")
	public String deleteDetails(@PathVariable("id") Long id)
	{
		ds.deleteData(id);
		return "Deleted Successfully..!";
	}
}