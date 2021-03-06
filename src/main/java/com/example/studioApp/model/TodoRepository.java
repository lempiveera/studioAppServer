package com.example.studioApp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


//repo for dealing with downstairs todo-list
public interface TodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findByPlace(String place); //Returns a list of tasks for certain studio. 
	long deleteByPlace(String place);
}
