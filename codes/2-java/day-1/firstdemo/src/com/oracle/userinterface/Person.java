package com.oracle.userinterface;

public class Person {
	String name;
	int id;
	//static String companyName="Oracle";
	static String companyName;
	
	static {
		System.out.println("in static block");
		companyName="Oracle";
	}

	public static String getCompany() {
		return companyName;
	}
	public Person() {
	}

	public Person(String name, int id) {
		System.out.println("obj created");
		this.name = name;
		this.id = id;
	}
}
