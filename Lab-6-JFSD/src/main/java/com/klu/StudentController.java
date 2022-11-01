package com.klu;

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
public class StudentController 
{
	@Autowired
	StudentService stu;
	
	@GetMapping("/reunion")
	public String getAll()
	{
		return stu.readData().toString();
//		return "Hello";
	}
	
	@PostMapping("/reunion")
	public String insertData(@RequestBody Student S)
	{
		return stu.saveData(S).toString();
	}
	
	@PutMapping("/reunion/{id}")
	public String updateDetails(@RequestBody Student s,@PathVariable("id") Long id)
	{
		return stu.updateData(s, id).toString();
	}
	
	@DeleteMapping("/reunion/{id}")
	public String deleteDetails(@PathVariable("id") Long id)
	{
		stu.deleteData(id);
		return "Data deleted Successfully...!";
	}
}
