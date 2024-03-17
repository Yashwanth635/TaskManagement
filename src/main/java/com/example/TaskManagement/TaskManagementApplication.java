package com.example.TaskManagement;

import com.example.TaskManagement.service.TaskService;
import com.example.TaskManagement.service.TaskServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.TaskManagement")

public class TaskManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
