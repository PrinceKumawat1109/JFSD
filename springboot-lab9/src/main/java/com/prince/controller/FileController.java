package com.prince.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prince.model.FileManager;

@RestController
@RequestMapping("/api")
public class FileController 
{
	@Autowired
	FileManager FM;
	
	@PostMapping("/upload")
	public String upload(@RequestParam("myFile") MultipartFile file)
	{
		return FM.fileUpload(file);
	}
	
	@GetMapping("/status")
	public String status()
	{
		return FM.updateStatus();
	}
	
	@GetMapping("/files")
	public String files()
	{
		return FM.getFiles().toString();
	}
}
