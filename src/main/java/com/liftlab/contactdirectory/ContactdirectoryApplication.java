package com.liftlab.contactdirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.liftlab.contactdirectory" })
public class ContactdirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactdirectoryApplication.class, args);
	}

}
