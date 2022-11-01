package com.prince.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prince.entity.EmployeeRegister;
import com.prince.repository.EmployeeRegisterRepository;

@Service
public class EmployeeRegisterManager 
{
	@Autowired
	EmployeeRegisterRepository er;
	
	public String insertData(EmployeeRegister e)
	{
		er.save(e);
		return "Inserted Successfully.....!";
	}
	
	public String readAll()
	{
	    return toJsonString(er.findAll());
	}
	
	public String toJsonString(Object obj)
	{
		GsonBuilder gb=new GsonBuilder();
		Gson g=gb.create();
		return g.toJson(obj);
	}
	public String deleteData(String user) 
	{
		er.deleteById(user);
		return "Daleted Success";
	}

	public String updateData(EmployeeRegister er2, String user) 
	{
		EmployeeRegister  tmp = er.findById(user).get();
		tmp.setFname(er2.getFname());
		tmp.setEmail(er2.getEmail());
		tmp.setGender(er2.getGender());
		tmp.setLname(er2.getLname());
		er.save(tmp);
		return "Data updated successfully...";
	}

	@SuppressWarnings("deprecation")
	public String loginData(String username, String password) 
	{
		if(er.existsById(username))
		{
			EmployeeRegister r=new EmployeeRegister();
			r=er.getById(username);
			if(r.getPwd().equals(password))
			{
				return "Success";
			}
			
		}
		return "Login Fail";
	}
	
	
}