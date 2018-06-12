package com.rest.mastermicro.model;

import java.util.Date;

public class User {

	private int id;
	private String name;
	private Date bday;
	
	public User() {
		
	}
	
	public User(int id, String name, Date bday) {
		super();
		this.id = id;
		this.name = name;
		this.bday = bday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bday=" + bday + "]";
	}
}
