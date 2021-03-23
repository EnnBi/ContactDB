package com.contactdb.akash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ContactDbApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ContactDbApplication.class, args);
	}

}
