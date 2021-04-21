package com.example.studioApp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PresentRepository extends CrudRepository<Present, Long> {

	List<Present> findByPerson(String person); // for junit testing
	long deleteByPerson(String person);
}
