package com.klu.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class DoctorManager implements DoctorService 
{
	@Autowired
	DoctorRepository dr;
	
	@Override
	public Doctor saveData(Doctor e) 
	{
		// TODO Auto-generated method stub
		return dr.save(e);
	}

	@Override
	public String readData() 
	{
		// TODO Auto-generated method stub
		return toJSONString(dr.findAll());
	}

	@Override
	public Doctor updateData(Doctor d, Long id) 
	{
		// TODO Auto-generated method stub
		Doctor doc=dr.findById(id).get();
		doc.setAddress(d.getAddress());
		doc.setAge(d.getAge());
		doc.setGender(d.getGender());
		doc.setGraduation(d.getGraduation());
		doc.setName(d.getName());
		return dr.save(doc);
	}

	@Override
	public void deleteData(Long id) 
	{
		// TODO Auto-generated method stub
		dr.deleteById(id);		
	}
	
	public String toJSONString(List<Doctor> list)
	{
	    GsonBuilder gb=new GsonBuilder();
	    Gson gson = gb.create();
	    return gson.toJson(list);
	}
}