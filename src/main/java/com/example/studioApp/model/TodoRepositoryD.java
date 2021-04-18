package com.example.studioApp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepositoryD extends CrudRepository<Todo, Long> {
	List<Todo> findByWho(String who);
	//long deleteByWho(String who); EI SALEE TARVII?
}
