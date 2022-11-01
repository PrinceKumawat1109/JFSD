package com.prince.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
	@GetMapping("/hello")
	public String hello(){
		return "Hello, you hosted in azure portal";
	}
}
