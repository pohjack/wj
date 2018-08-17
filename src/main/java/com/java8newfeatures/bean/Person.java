package com.java8newfeatures.bean;

public class Person {
    public String name;
    public int age;
    String address;
    public Person(String name,int age,String address){
        this.address=address;
        this.age=age;
        this.name=name;
    }
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
    
}
