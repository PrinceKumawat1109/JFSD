package com.prince.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.model.Bike;
import com.prince.model.Car;
import com.prince.model.Vehicle;

@RestController
@RequestMapping("/api")
public class MyController 
{
	Vehicle V;
	
	@GetMapping("/bike")
	public String bike()
	{
		V = new Bike();
		return V.startJourney();
	}
	
	@GetMapping("/car")
	public String car()
	{
		V = new Car();
		return V.startJourney();
	}
}
