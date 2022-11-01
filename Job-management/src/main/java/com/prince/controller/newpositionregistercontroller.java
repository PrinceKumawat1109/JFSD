package com.prince.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.entity.newpositionregister;
import com.prince.model.newpositionregistermanager;

@RestController
@RequestMapping("/api")
public class newpositionregistercontroller {
	@Autowired
	newpositionregistermanager np;
	@PostMapping("/new/register")
	public String inserting(@RequestBody newpositionregister e)
	{
		return np.insertData(e);
	}
	@GetMapping("/new/register")
	public String getData()
	{
		return np.readAll();
	}
	@DeleteMapping("/new/eregister/{jobtitle}")
	public String deleteDatA(@PathVariable("jobtitle") String jobtitle)
	{
		return np.deleteData(jobtitle);
	}
	@PutMapping("/new/eregister/{jobtitle}")
	public String updateParticipants(@RequestBody  newpositionregister n,@PathVariable("jobtitle") String jobtitle)
	{
		return np.updateData(n,jobtitle);
	}
	
}
