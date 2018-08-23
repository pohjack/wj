package com.java8newfeatures.bean;

import java.util.Objects;

public class Person {
    public String name;
    public int age;
    public String address;
    public Person(String name,int age,String address){
        this.address=address;
        this.age=age;
        this.name=name;
    }
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, address);
    }
}
