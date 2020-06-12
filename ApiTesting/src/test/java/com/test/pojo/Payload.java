package com.test.pojo;

public class Payload {
	
	String name;
	String salary;
	Age age;
	
	public Payload(String name, String salary, Age age)
	{
		this.name=name;
		this.salary = salary;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	

}
