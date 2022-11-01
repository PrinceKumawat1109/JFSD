package com.prince.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prince.entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

}
