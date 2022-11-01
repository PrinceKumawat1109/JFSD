package com.prince.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prince.entity.EmployeeRegister;

@Repository
public interface EmployeeRegisterRepository extends JpaRepository<EmployeeRegister,String> 
{
	
}