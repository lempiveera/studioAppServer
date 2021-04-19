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
	private String place;
	private String task;
	private String who;

	//Todo class, task = todo, or the thing that needs to be done
	//who = who will do it, can it be empty?
	//place = downstairs, upstairs, sumu
	
	
	public Todo() {}

	public Todo(String place, String task, String who) {
		super();
		this.place = place;
		this.task = task;
		this.who = who;
	}
	
	//public Task(String task) {
		//constructor for creating todo without who does it
		//this.task = task;
	//} IS THIS NEEDED?
	

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

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
		return "Todo [id=" + id + ", place=" + place + ", task=" + task + ", who=" + who + "]";
	}


}
