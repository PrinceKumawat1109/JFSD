package com.prince.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.entity.Participants;
import com.prince.model.SamyakManager;

@RestController
@RequestMapping("/api")
public class SamyakController 
{
	@Autowired
	SamyakManager S;
	
	@PostMapping("/registration")
	public String registration(@RequestBody Participants P)
	{
		return S.saveParticipants(P);
	}
	
	@GetMapping("/participants")
	public String participants()
	{
		return S.readUsers().toString();
	}
	
	@GetMapping("/events")
	public String events()
	{
		return S.readEvents().toString();
	}
	
	@GetMapping("/participants/{id}")
	public String participants(@PathVariable("id") Long eid)
	{
		return S.readParticipants(eid).toString();
	}
	
	@GetMapping("/countparticipants")
	public String countParticipants()
	{
		return S.countParticipants().toString();
	}
	
	@PutMapping("/participants/update/{id}")
	public String updateParticipants(@RequestBody Participants p,@PathVariable("id") Long id)
	{
		return S.updateParticipants(p, id);
	}
}
