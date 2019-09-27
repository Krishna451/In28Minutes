package com.in28minutes.rest.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User Deatails")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2,message = "Name should have atleast 2 characters")
	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Date of Birth Should have in Past")
	private Date DOB;
	
	
	protected User() {
	
	}
	public User(Integer id, String name, Date dOB) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DOB=" + DOB + "]";
	}
	

	
	
	
}
