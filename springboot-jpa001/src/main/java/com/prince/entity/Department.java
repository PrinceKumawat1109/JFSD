package com.prince.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department 
{
	@Id
	private Long id;
	private String name;
	private String location;
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
