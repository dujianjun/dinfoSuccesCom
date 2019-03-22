package com.dscexpen.model;

public class Student {
	private String name;
	private int age;
	
	
	
	
	public Student(String name, int age) {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	public void read(){
		System.out.println("学生读书。。。。。。。");
	}
	public void eat(String apple){
		System.out.println("学生吃"+apple);
	}

}
