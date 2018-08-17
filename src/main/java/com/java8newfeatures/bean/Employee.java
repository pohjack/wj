package com.java8newfeatures.bean;

import com.java8newfeatures.code.streamapi.Status;

/**
 * @author: wj
 * @version: v1
 * @date:2018年8月12日 上午9:54:26
 * @description:
 */
public class Employee {
	private int id;
	private int age;
	private String name;
	private double salary;
	private Status status;
	

	public Employee(int id,String name,int age, double salary,Status status) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee(int id, String name,int age, double salary) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

	public Employee(int id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	public Employee() {
		super();
	}

	public Employee(int id) {
		super();
		this.id = id;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public Employee(String name,int id) {
		this.name=name;
		this.id=id;
	}

	public Employee(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String show() {
		return this.toString();
	}

}
