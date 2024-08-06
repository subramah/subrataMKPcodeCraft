package com.collecton.org;

import java.util.Objects;

class Person
{
	int adharId;
	String name;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int adharId, String name) {
		super();
		this.adharId = adharId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [adharId=" + adharId + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adharId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDetails other = (PersonDetails) obj;
		return adharId == other.adharId && Objects.equals(name, other.name);
	}
}
public class DemoOne {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Maya";
		String s2 = "Maya";
		//if two objects are equal then their hashcodes are also equal
		int hash11 =s1.hashCode();
		int hash22 = s2.hashCode();
		System.out.println(hash11);
		System.out.println(hash22);
		System.out.println(s1.equals(s2));
		PersonDetails p1  = new PersonDetails(345,"Nirosha");
		PersonDetails p2  = new PersonDetails(390,"Pavan");
		PersonDetails p3  = new PersonDetails(345,"Nirosha");
		int p1code = p1.hashCode();
		int p2code = p2.hashCode();
		int p3code = p3.hashCode();
		System.out.println("P1 and p3 are equal" + p1.equals(p3));
		System.out.println("The hashcode of P1 object is " + p1code);
		System.out.println("The hashcode of P2 object is " + p2code);
		//if equals method retuerns true then the hashcode is also equal
		System.out.println("The hashcode of P3 object is " + p3code);
	    //----------------------------------------------------
		//converse of the contract not true
		String str1 = "FB";
		String str2 = "Ea";
		int hash1 = str1.hashCode();
		int hash2 = str2.hashCode();
		System.out.println(hash1);
		System.out.println(hash2);
	}
 
	
}