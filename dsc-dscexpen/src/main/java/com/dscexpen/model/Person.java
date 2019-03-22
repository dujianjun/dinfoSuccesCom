package com.dscexpen.model;

public class Person implements Comparable<Person>{
	
	private String name;
	private Integer age;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Person o) {
		int h=this.age-o.age;
		return h==0?this.name.hashCode()-o.hashCode():h;
	}
	
	

}
