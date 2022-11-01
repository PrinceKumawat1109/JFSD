package com.prince;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Lab12Application extends SpringBootServletInitializer {

	@Override  
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	  {  
	    return application.sources(Lab12Application.class);  
	  }
	public static void main(String[] args) {
		SpringApplication.run(Lab12Application.class, args);
	}

}
