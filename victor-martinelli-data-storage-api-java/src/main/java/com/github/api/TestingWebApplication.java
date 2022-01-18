package com.github.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.api")
public class TestingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingWebApplication.class, args);
	}
}
