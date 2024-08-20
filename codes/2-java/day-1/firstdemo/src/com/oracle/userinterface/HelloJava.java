package com.oracle.userinterface;

import java.util.Scanner;

import com.oracle.utility.Messenger;

public class HelloJava {
	public static void main(String[] args) {
		// System.out.println("Hello Java");
		Messenger messenger = new Messenger();
		String welcomeMessage = messenger.getMessage("joydip");
		System.out.println(welcomeMessage);
		Person anilPerson = create("anil",1);
		Person sunilPerson = create("sunil",2);
		//Person.getCompany();
	}

	static Person create(String name, int id) {
		Person p = new Person(name,id);
		return p;
	}
}
