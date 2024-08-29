package com.springbootapps.usersapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class UsersappApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersappApplication.class, args);
	}

}
