package com.brano.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

	@GetMapping(value={"/", "/list"})
	public String list(Model model) {
		Task task = new Task("Foo Task", "Foo Description");
		model.addAttribute("task", task);
		return "list";
	}
}