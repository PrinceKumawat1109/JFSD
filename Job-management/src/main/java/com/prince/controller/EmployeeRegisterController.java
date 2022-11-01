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

import com.prince.entity.EmployeeRegister;
import com.prince.model.EmployeeRegisterManager;


@RestController
@RequestMapping("/api")
public class EmployeeRegisterController 
{
	@Autowired
	EmployeeRegisterManager em;
	
	@PostMapping("/register")
	public String inserting(@RequestBody EmployeeRegister e)
	{
		return em.insertData(e);
	}
	
	@GetMapping("/register")
	public String getData()
	{
		return em.readAll();
	}
	@DeleteMapping("/register/{username}")
	public String deleteDatA(@PathVariable("username") String user)
	{
		return em.deleteData(user);
	}
	@PutMapping("/register/{username}")
	public String updateParticipants(@RequestBody  EmployeeRegister er,@PathVariable("username") String user )
	{
		return em.updateData(er,user);
	}
	@PostMapping("/register/login/{username}/{password}")
    public String registerlogin(@PathVariable("username") String username,@PathVariable("password") String password)
    {
		return em.loginData(username,password);
    }
}