package com.example.studioApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Present {
	
	// the present entity is for marking who is currently present at studio/sumu
	
	@ManyToOne
	@JoinColumn(name = "sId")
	private Space space;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String person;
	
	//lol dont use where as a name it breaks the database

	
	
	public Present() { }
	
	public Present(String person, Space space) {
		super();
		this.person = person;
		this.space = space;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}
	
	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}
}
