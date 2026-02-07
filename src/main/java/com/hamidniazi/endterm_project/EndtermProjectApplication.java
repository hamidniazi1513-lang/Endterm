package com.hamidniazi.endterm_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EndtermProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(EndtermProjectApplication.class, args);

		com.hamidniazi.endterm_project.patterns.LoggerSingleton.getInstance().log("System Started!");
	}

}