package com.springapps.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FirstappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstappApplication.class, args);
	}

	@GetMapping(path = "message")
	public String getMessage() {
		return "hello..";
	}
}
