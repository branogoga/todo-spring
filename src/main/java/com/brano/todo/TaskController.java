package com.brano.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping(value={"/", "/list"})
	public String list(Model model) {
		Iterable<Task> tasks = taskRepository.findAll();
		model.addAttribute("tasks", tasks);
		return "list";
	}

	@GetMapping(value={"/add"})
	public ModelAndView add() {
		Task task = new Task("Task " + UUID.randomUUID().toString(), "Description " + UUID.randomUUID().toString());
		taskRepository.save(task);
		return new ModelAndView("redirect:/list");
	}

	@GetMapping(value={"/remove"})
	public ModelAndView remove(@RequestParam(value = "id", required = true) Integer id) {
		Optional<Task> task = taskRepository.findById(id);
		if(task.isPresent()) {
			taskRepository.delete(task.get());
		}
		return new ModelAndView("redirect:/list");
	}
}