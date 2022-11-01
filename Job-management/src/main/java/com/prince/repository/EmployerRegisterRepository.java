package com.prince.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prince.entity.EmployerRegister;

@Repository
public interface EmployerRegisterRepository extends JpaRepository<EmployerRegister,String> 
{
	
}