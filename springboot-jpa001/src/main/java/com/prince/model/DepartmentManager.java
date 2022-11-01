package com.prince.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.prince.entity.Department;
import com.prince.repository.DepartmentRepository;

@Service
public class DepartmentManager implements DepartmentService
{
	@Autowired
	DepartmentRepository deptRepository;
	@Override
	public Department saveData(Department D) {
		return deptRepository.save(D);
	}

	@Override
	public List<Department> readData() {
		return deptRepository.findAll();
	}

	@Override
	public Department updateData(Department D, Long id) {
		Department tmp = deptRepository.findById(id).get();
		tmp.setName(D.getName());
		tmp.setLocation(D.getLocation());
		return deptRepository.save(tmp);
	}

	@Override
	public void deleteData(Long id) {
		deptRepository.deleteById(id);
	}
	
}
