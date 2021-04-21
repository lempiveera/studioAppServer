package com.example.studioApp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PriorityRepository extends CrudRepository<Priority, Long> {
	
	List<Todo> findByUrgency(String urgency);
	long deleteByUrgency(String urgency);
}
