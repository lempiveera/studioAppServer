package com.example.studioApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studioApp.model.TodoRepository;
import com.example.studioApp.model.PriorityRepository;
import com.example.studioApp.model.Todo;

@Controller
public class SumuController {

	@Autowired
	private TodoRepository trepo;

	@Autowired
	private PriorityRepository prepository;

	// list of todos for sumu
	@GetMapping(value = "/sumu")
	public String sumu(Model model) {
		model.addAttribute("tasks", trepo.findByPlace("S"));
		return "s/sumu";
	}

	// adding a new todo for sumu
	@RequestMapping(value = "addS")
	public String addTaskS(Model model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("priorities", prepository.findAll());
		return "s/sAddTask";
	}

	// saving new todo
	@PostMapping(value = "saveS")
	public String saveTask(Todo task) {
		trepo.save(task);
		return "redirect:sumu";
	}

	// Deleting only possible for admin users
	@GetMapping(value = "/delete_S/{id}")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTask(@PathVariable("id") Long id, Model model) {
		trepo.deleteById(id);
		return "redirect:/sumu";
	}

	// Editing possible for all users
	@GetMapping(value = "/edit_S/{id}")
	public String editTask(@PathVariable("id") Long id, Model model) {
		model.addAttribute("todo", trepo.findById(id));
		model.addAttribute("priorities", prepository.findAll());
		return "s/sEditTask";
	}

	// REST, returns sumus todos in JSON
	@RequestMapping(value = "/sumu_index", method = RequestMethod.GET)
	public @ResponseBody List<Todo> FindUpstairsTodos(String place) {
		return (List<Todo>) trepo.findByPlace("S");
	}
}
