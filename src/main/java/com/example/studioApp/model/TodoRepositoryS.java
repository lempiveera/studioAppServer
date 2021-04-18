package com.example.studioApp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


//repo for dealing with sumu todo-list
public interface TodoRepositoryS extends CrudRepository<Todo, Long> {
	List<Todo> findByWho(String who);
	//long deleteByWho(String who); EI SALEE TARVII?
}
