package com.prince;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootLab7Application extends  SpringBootServletInitializer {
	
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	  {
	    return builder.sources(SpringbootLab7Application.class);
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootLab7Application.class, args);
	}

}
