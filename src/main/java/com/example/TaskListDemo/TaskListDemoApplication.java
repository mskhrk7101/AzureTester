package com.example.TaskListDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.TaskListDemo.TaskListDemoApplication;

@SpringBootApplication
public class TaskListDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskListDemoApplication.class, args);
	}
	@RequestMapping("/aaaa")
	String hello(){
		return "AAA AA";
	}
}
