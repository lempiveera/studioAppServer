package com.example.studioApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Space {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "space")
	private List<Present> atPresent;
	
	//this for choosing a space when checking yourself in
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	//priority Id
	Long sId;
	String location;
	
	public Space() { }
	
	public Space(String location) {
		this.location = location;
	}
	
	
	public List<Present> getAtPresent() {
		return atPresent;
	}

	public void setAtPresent(List<Present> atPresent) {
		this.atPresent = atPresent;
	}

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
