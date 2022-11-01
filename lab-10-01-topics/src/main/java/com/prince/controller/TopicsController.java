package com.prince.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.model.TopicsManager;

@RestController
@RequestMapping("/api")
public class TopicsController 
{
	@Autowired
	TopicsManager TM;
	
	@GetMapping("/topics/{cid}")
	public String topics(@PathVariable("cid") Long cid)
	{
		return TM.getTopics(cid).toString();
	}
}
