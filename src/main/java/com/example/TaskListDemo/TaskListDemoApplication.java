package com.example.TaskListDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class TaskListDemoApplication {

	public static void main(String[] args) {SpringApplication.run(TaskListDemoApplication.class, args);}
	@RequestMapping("/")
	String hello(){
		return """
    			Hello.It Works!
    			現在時刻%sです。
				""".formatted(LocalDateTime.now());
	}
}
