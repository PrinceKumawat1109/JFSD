package com.prince.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employer")
public class EmployerRegister 
{
	@Id
	String email;
	
	String com_name;
	String com_add;
	String pwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_add() {
		return com_add;
	}
	public void setCom_add(String com_add) {
		this.com_add = com_add;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return  "EmployerRegister [email=" + email + ", com_name=" + com_name + ", com_add=" + com_add + ", pwd=" + pwd
				+ "]";
	}
	
	
}