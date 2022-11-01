package com.prince.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prince.entity.Participants;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participants, Long> 
{
	//@Query(value = "SELECT COUNT(*) FROM PARTICIPANTS", nativeQuery = true)
	@Query("SELECT COUNT(P) FROM Participants P")
	public Long countParticipants();
	
	@Query("SELECT P FROM Participants P WHERE P.event_id = :eid")
	public List<Participants> readAllById(@Param("eid") Long eid);
}
