package com.hibernetExample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class HibernetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernetApplication.class, args);

	}



}
