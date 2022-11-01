package com.klu.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class PatientManager implements PatientService 
{
	@Autowired
	PatientRepository pr;

	@Override
	public Patient saveData(Patient p) 
	{
		// TODO Auto-generated method stub
		return pr.save(p);
	}

	@Override
	public String readData() 
	{
		// TODO Auto-generated method stub
		return toJSONString(pr.findAll());
	}

	@Override
	public Patient updateData(Patient p, Long id) 
	{
		// TODO Auto-generated method stub
		Patient pt=pr.findById(id).get();
		pt.setAddress(p.getAddress());
		pt.setAge(p.getAge());
		pt.setGender(p.getGender());
		pt.setIssue(p.getIssue());
		pt.setName(p.getName());
		return pr.save(pt);
	}

	@Override
	public void deleteData(Long id) 
	{
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}
	
	public String toJSONString(List<Patient> l)
	{
		GsonBuilder gb=new GsonBuilder();
		Gson gson=gb.create();
		return gson.toJson(l);
	}
}
