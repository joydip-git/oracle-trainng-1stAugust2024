package com.hibernateapps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernateapps.models.User;
import com.hibernateapps.repository.RepositoryContract;
import com.hibernateapps.repository.UserRepository;

public class App {
    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beansconfig.xml")) {
            RepositoryContract<User> dao = context.getBean(UserRepository.class);
            boolean status = dao.add(new User(1, "anil"));
            System.out.println(status ? "added" : "not added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
