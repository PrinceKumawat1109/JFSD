package com.klu.demo;

public interface DoctorService 
{
	public Doctor saveData(Doctor e);
	public String readData();
	public Doctor updateData(Doctor e,Long id);
	public void deleteData(Long id);
}