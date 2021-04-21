package com.example.studioApp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PriorityRepository extends CrudRepository<Priority, Long> {
	
	List<Priority> findByUrgency(String urgency);
	long deleteByUrgency(String urgency);
}
