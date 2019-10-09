package com.airline.service.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Ravi Ranjan Kumar
 * @version 1.0
 * This class is SpringBootApplication class.
 * On run of this class spring automatically starts up a web container which enables us to access all the REST services on
 * the localhost with 7077 port
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	
}
