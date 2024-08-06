package com.collecton.org;

import java.util.List;

public class Employee {
    private String name;
    private double salary;
    private int age;
    private List<String> city;
    
    
    
    
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + ", city=" + city + "]";
	}
	public Employee(String name, double salary, int age, List<String> city) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}

    
  
}
