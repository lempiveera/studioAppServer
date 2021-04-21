package com.example.studioApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studioApp.model.PriorityRepository;
import com.example.studioApp.model.Todo;
import com.example.studioApp.model.TodoRepository;

@Controller
public class UpstairsController {

	@Autowired
	private TodoRepository trepo; 
	
	@Autowired
	private PriorityRepository prepository;
	
	@GetMapping(value = "/upstairs")
	public String upstairs(Model model) {
		model.addAttribute("tasks", trepo.findByPlace("U"));
		return "u/upstairs";
	}
	
	@RequestMapping(value="addU")
	public String addTaskD(Model model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("priorities", prepository.findAll());
		return "u/uAddTask";
	}

	//VARIABLE NAMES TASK VS TODO FIGURE IT OUT what is the best way
	@PostMapping(value = "saveU")
	public String saveTask(Todo task) {
		trepo.save(task);
		return "redirect:upstairs";
	}
	
	//TODO "No class com.example.studioApp.model.Todo entity with id 5 exists!" WHAT IS THIS?
	//FIGURE IT OUT
	//JUUUH MIGHT BE A BIGGER ISSUE
	@GetMapping(value = "/delete_U/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTask(@PathVariable("id") Long id, Model model) {
		trepo.deleteById(id);
		return "redirect:/upstairs";
	}
	
	@GetMapping(value = "/edit_U/{id}")
	public String editTask(@PathVariable("id") Long id, Model model) {
		model.addAttribute("todo", trepo.findById(id));
		model.addAttribute("priorities", prepository.findAll());
		return "u/uEditTask";
	}
}
