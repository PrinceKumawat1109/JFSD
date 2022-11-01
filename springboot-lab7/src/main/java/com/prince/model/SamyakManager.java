package com.prince.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prince.entity.Events;
import com.prince.entity.Participants;
import com.prince.repository.EventsRepository;
import com.prince.repository.ParticipantsRepository;

@Service
public class SamyakManager 
{
	@Autowired 
	ParticipantsRepository pRepository;
	
	@Autowired
	EventsRepository eRepository;
	
	public String saveParticipants(Participants P)
	{
		pRepository.save(P);
		return "Registered Successfully, " + "No. of Participants: " + countParticipants();
	}
	
	public List<String> readEvents()
	{
		List<String> elist=new ArrayList<String>();
		for(Events e:eRepository.findAll())
			elist.add(toJsonString(e));
		return elist;
	}
	
	public List<String> readUsers()
	{
		List<String> elist=new ArrayList<String>();
		for(Participants p:pRepository.findAll())
			elist.add(toJsonString(p));
		return elist;
	}
	
	public List<String> readParticipants(Long eid)
	{
		List<String> list = new ArrayList<String>();
		for(Participants P:pRepository.readAllById(eid))
			list.add(toJsonString(P));
		return list;
	}
	
	public String updateParticipants(Participants P, Long id)
	{
		Participants tmp = pRepository.findById(id).get();
		tmp.setName(P.getName());
		tmp.setEmailid(P.getEmailid());
		tmp.setPhno(P.getPhno());
		tmp.setEvent_id(P.getEvent_id());
		pRepository.save(tmp);
		return "Data updated successfully...";
	}
	
	
	
	public Long countParticipants()
	{
		return pRepository.countParticipants();
	}
	
	public String toJsonString(Object obj)
	{
		GsonBuilder gbuilder = new GsonBuilder();
		Gson gson = gbuilder.create();
		return gson.toJson(obj);
	}
}