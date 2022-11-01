package com.prince.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prince.entity.Topics;

@Service
public class TopicsManager 
{
	@Autowired
	TopicsRepository TR;
	
	//Read data from Database
	public List<String> getTopics(Long cid)
	{
		List<String> list = new ArrayList<String>();
		for(Topics T : TR.getTopicsByCID(cid))
			list.add(toJsonString(T));
		return list;
	}
	
	//To convert Java Object to JSON string
	public String toJsonString(Object obj)
	{
		GsonBuilder GB = new GsonBuilder();
		Gson GS = GB.create();
		return GS.toJson(obj);
	}
}
