package com.ims.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {

	public City() {
		
	}
	@Column(name="id")
	@Id
	private int id;
	@Column(name="city")
	private String name;
	@Column(name="state_id")
	private int stateId;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getStateId() {
		return stateId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
}
