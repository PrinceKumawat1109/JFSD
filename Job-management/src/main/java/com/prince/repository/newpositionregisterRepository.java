package com.prince.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prince.entity.newpositionregister;

@Repository
public interface newpositionregisterRepository extends JpaRepository<newpositionregister,String> {

}
