package com.example.studioApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Priority {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "priority")
	private List<Todo> todos;
	
	//For marking the urgency of a task to be done
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	//priority Id
	Long pId;
	String urgency;
	
	public Priority() { }
	
	public Priority(String urgency) {
		this.urgency = urgency;
	}
	
	
	public List<Todo> getBooks() {
		return todos;
	}

	public void setBooks(List<Todo> todos) {
		this.todos = todos;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	
	
}
