package com.example.TaskListDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    record TaskItem(String id, String task, String deadline, boolean done) {
    }

    private List<TaskItem> taskItems = new ArrayList<>();
    @RequestMapping("/hello")
//    @ResponseBody
//    String hello() {
//        return """
//                <html>
//                    <head><title>Hello</title></head>
//                    <body>
//                        <h1>Hello</h1>
//                        It works!<br>
//                        現在時刻は%sです。
//                    </body>
//                </html>
//                """.formatted(LocalDateTime.now());
    String hello(Model model){
        model.addAttribute("time", LocalDateTime.now());
        return "hello";
    }

    @GetMapping(value = "/list")
    String listItems(Model model) {
        model.addAttribute("taskList", taskItems);
        return "home";
    }
}
