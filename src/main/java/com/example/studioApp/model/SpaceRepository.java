package com.example.studioApp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpaceRepository extends CrudRepository<Space, Long> {
	
	List<Space> findByLocation(String location); // for junit testing
	long deleteByLocation(String location);
}
