package com.dscexpen.model;

import java.util.Date;

public class Mybean {
	private String id;
	private String name;
	private Date date;
	public Mybean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mybean(String id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
