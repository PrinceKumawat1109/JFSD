package com.prince.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events 
{
	@Id
	private Long id;
	private String eventname;	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	@Override
	public String toString() {
		return "Events [id=" + id + ", eventname=" + eventname + "]";
	}
}
