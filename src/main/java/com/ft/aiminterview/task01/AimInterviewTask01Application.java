package com.ft.aiminterview.task01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
public class AimInterviewTask01Application {

	public static void main(String[] args) {
		SpringApplication.run(AimInterviewTask01Application.class, args);
	}

}
