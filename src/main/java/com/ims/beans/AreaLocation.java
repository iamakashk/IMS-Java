package com.ims.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="AREA_LOCATION")
public class AreaLocation {

	public AreaLocation() {
		
	}
	
	@Column(name="al_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="al_name")
	private String name;
	
	@Column(name="al_description_1")
	private String description1;
	@Column(name="al_description_2")
	private String description2;
	@Column(name="al_city")
	private String city;
	
	@Column(name="al_deleted_flg")
	private String deleted;
	
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription1() {
		return description1;
	}
	public String getDescription2() {
		return description2;
	}
	public String getCity() {
		return city;
	}
	public void setDescription1(String description1) {
		this.description1 = description1;
	}
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}

