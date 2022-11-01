package com.klu.demo;

public interface PatientService 
{
	public Patient saveData(Patient p);
	public String readData();
	public Patient updateData(Patient p,Long id);
	public void deleteData(Long id);
}
