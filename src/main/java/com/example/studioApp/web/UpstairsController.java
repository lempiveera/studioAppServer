package com.example.studioApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studioApp.model.Present;
import com.example.studioApp.model.PriorityRepository;
import com.example.studioApp.model.Todo;
import com.example.studioApp.model.TodoRepository;

@Controller
public class UpstairsController {

	@Autowired
	private TodoRepository trepo;

	@Autowired
	private PriorityRepository prepository;

	// list of todos for upstairs
	@GetMapping(value = "/upstairs")
	public String upstairs(Model model) {
		model.addAttribute("tasks", trepo.findByPlace("U"));
		return "u/upstairs";
	}

	// adding a new todo for upstairs
	@RequestMapping(value = "addU")
	public String addTaskD(Model model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("priorities", prepository.findAll());
		return "u/uAddTask";
	}

	// saving new todo
	@PostMapping(value = "saveU")
	public String saveTask(Todo task) {
		trepo.save(task);
		return "redirect:upstairs";
	}

	// Deleting only possible for admin users
	@GetMapping(value = "/delete_U/{id}")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTask(@PathVariable("id") Long id, Model model) {
		trepo.deleteById(id);
		return "redirect:/upstairs";
	}

	// Editing possible for all users
	@GetMapping(value = "/edit_U/{id}")
	public String editTask(@PathVariable("id") Long id, Model model) {
		model.addAttribute("todo", trepo.findById(id));
		model.addAttribute("priorities", prepository.findAll());
		return "u/uEditTask";
	}

	
	//REST, returns upstrairs todos in JSON
	@RequestMapping(value="/upstairs_index", method = RequestMethod.GET)
	public @ResponseBody List<Todo> FindUpstairsTodos(String place) {
		return (List<Todo>) trepo.findByPlace("U");
	}

}
