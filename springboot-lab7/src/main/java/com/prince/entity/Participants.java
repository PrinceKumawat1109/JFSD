package com.prince.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
public class Participants 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String emailid;
	private String phno;
	private Long event_id;
	
	
	public Long getId() {
		return id;
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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	@Override
	public String toString() {
		return "Participants [id=" + id + ", name=" + name + ", emailid=" + emailid + ", phno=" + phno + ", event_id="
				+ event_id + "]";
	}
	
}
