package com.klu;

import java.util.List;


public interface StudentService 
{
	public Student saveData(Student s);
	public List<Student> readData();
	public Student updateData(Student s, Long id);
	public void deleteData(Long id);
}