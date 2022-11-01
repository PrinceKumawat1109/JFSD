package com.prince.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prince.entity.newpositionregister;
import com.prince.repository.newpositionregisterRepository;

@Service
public class newpositionregistermanager {
	@Autowired
	newpositionregisterRepository np;
	
	public String insertData(newpositionregister e)
	{
		np.save(e);
		return "Inserted Successfully.....!";
	}
	public String readAll()
	{
	    return toJsonString(np.findAll());
	}
	public String toJsonString(Object obj)
	{
		GsonBuilder gb=new GsonBuilder();
		Gson g=gb.create();
		return g.toJson(obj);
	}
	public String deleteData(String jobtitle) 
	{
		np.deleteById(jobtitle);
		return "Deleted Success";
	}

	public String updateData(newpositionregister er2, String jobtitle) 
	{
		newpositionregister  tmp = np.findById(jobtitle).get();
		tmp.setJobtitle(er2.getJobtitle());
		tmp.setJobdes(er2.getJobdes());
		tmp.setLoc(er2.getLoc());
		tmp.setType(er2.getType());
		tmp.setUrl(er2.getUrl());
		tmp.setDate(er2.getDate());
		tmp.setComname(er2.getComname());
		tmp.setWebsite(er2.getWebsite());
		np.save(tmp);
		return "Data updated successfully...";
	}
}
