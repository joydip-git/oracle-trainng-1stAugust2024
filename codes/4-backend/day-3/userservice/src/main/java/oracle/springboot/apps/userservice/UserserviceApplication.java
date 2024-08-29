package oracle.springboot.apps.userservice;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
		System.out.println("server started....");
	}
}
