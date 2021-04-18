package com.example.studioApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String task;
	private String who;

	//Todo class, task = todo, or the thing that needs to be done
	//who = who will do it, can it be empty?
	
	
	public Todo() {}

	public Todo(String task, String who) {
		super();
		this.task = task;
		this.who = who;
	}
	
	//public Task(String task) {
		//constructor for creating todo without who does it
		//this.task = task;
	//} IS THIS NEEDED?
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", who=" + who + "]";
	}

}
