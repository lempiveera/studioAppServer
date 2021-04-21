package com.example.studioApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {

	//Entity for saving todos. Task means what task needs to be done, who is who is going to do it
	//Place means which studio/sumu. Its marked with either D for downstairs, S for sumu and U for upstairs
	//Priority for how urgent the task is
	
	@ManyToOne
	@JoinColumn(name = "pId")
	private Priority priority;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String place;
	private String task;
	private String who;


	public Todo() {
	}

	public Todo(String place, String task, String who, Priority priority) {
		super();
		this.place = place;
		this.task = task;
		this.who = who;
		this.priority = priority;
	}



	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

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
