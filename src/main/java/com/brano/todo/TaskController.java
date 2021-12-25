package com.brano.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

	@GetMapping(value={"/", "/list"})
	public String list(Model model) {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task("Task 1", "Description 1"));
		tasks.add(new Task("Task 2", "Description 2"));
		model.addAttribute("tasks", tasks);
		return "list";
	}
}