package com.prince.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prince.entity.EmployerRegister;
import com.prince.repository.EmployerRegisterRepository;

@Service
public class EmployerRegisterManager 
{
	@Autowired
	EmployerRegisterRepository er;
	
	public String insertData(EmployerRegister e)
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
	public String deleteData(String email) 
	{
		er.deleteById(email);
		return "Deleted Success";
	}

	public String updateData(EmployerRegister er2, String user) 
	{
		EmployerRegister  tmp = er.findById(user).get();
		tmp.setCom_add(er2.getCom_add());
		tmp.setCom_name(er2.getCom_name());
		tmp.setPwd(er2.getPwd());
		er.save(tmp);
		return "Data updated successfully...";
	}

	@SuppressWarnings("deprecation")
	public String loginData(String email, String password) 
	{
		if(er.existsById(email))
		{
			EmployerRegister r=new EmployerRegister();
			r=er.getById(email);
			if(r.getPwd().equals(password))
			{
				return "Success";
			}
		}
		return "Login Fail";
	}
	
	
}