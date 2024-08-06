package com.collecton.org;

public class RecordTest {

	public static void main(String[] args) {
		//record
		PersonDetails p1= new PersonDetails(11, "John", "john@gmail.com");
		PersonDetails p2= new PersonDetails(11, "John", "john@gmail.com");
		System.out.println("immutable record "+p1.equals(p2));
		
		//class
		Customer c1=new Customer(11, "John", "john@gmail.com");
		Customer c2=new Customer(11, "John", "john@gmail.com");
		
		System.out.println("immutable class "+c1.equals(c2));
	}
	
	
}
