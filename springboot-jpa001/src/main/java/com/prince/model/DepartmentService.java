package com.prince.model;

import java.util.List;

import com.prince.entity.Department;

public interface DepartmentService  
{
	public Department saveData(Department D);
	public List<Department> readData();
	public Department updateData(Department D, Long id);
	public void deleteData(Long id);
	
}
