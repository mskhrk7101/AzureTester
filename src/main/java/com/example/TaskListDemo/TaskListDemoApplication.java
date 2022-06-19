package com.example.TaskListDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RestController
public class TaskListDemoApplication {
	record TaskItem(String id, String task, String deadline, boolean done) {
	}

	private List<TaskItem> taskItems = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(TaskListDemoApplication.class, args);
	}

	@RequestMapping("/")
	String hello() {
		return """
				Hello.It Works!
				現在時刻%sです。
				""".formatted(LocalDateTime.now());
	}

	@GetMapping("/restadd")
	String addItem(@RequestParam("task") String task, @RequestParam("deadline") String deadline) {
		String id = UUID.randomUUID().toString().substring(0, 8);
		TaskItem item = new TaskItem(id, task, deadline, false);
		taskItems.add(item);

		return "タスクを追加しました";
	}
}
