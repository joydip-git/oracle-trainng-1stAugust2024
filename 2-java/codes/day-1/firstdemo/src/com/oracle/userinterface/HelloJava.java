package com.oracle.userinterface;
import com.oracle.utility.Messenger;

public class HelloJava {
	public static void main(String[] args) {
		//System.out.println("Hello Java");
		Messenger messenger = new Messenger();
		String welcomeMessage = messenger.getMessage("joydip");
		System.out.println(welcomeMessage);
	}
}
