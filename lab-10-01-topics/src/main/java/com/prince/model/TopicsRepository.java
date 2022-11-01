package com.prince.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prince.entity.Topics;

@Repository
public interface TopicsRepository extends JpaRepository<Topics, Long> 
{
	@Query("SELECT T FROM Topics T WHERE T.cid=:cid")
	public List<Topics> getTopicsByCID(@Param("cid") Long cid);
}
