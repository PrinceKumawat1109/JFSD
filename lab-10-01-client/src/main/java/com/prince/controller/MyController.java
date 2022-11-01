package com.prince.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class MyController 
{
	//To consume course micro-service
	@GetMapping("/callcourseapi")
	public String callCourseApi()
	{
		String url = "http://localhost:8081/api/course";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	//To consume topics micro-service
	@GetMapping("/calltopicsapi/{cid}")
	public String callTopicsApi(@PathVariable("cid") Long cid)
	{
		String url = "http://localhost:8082/api/topics/" + cid;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
}
