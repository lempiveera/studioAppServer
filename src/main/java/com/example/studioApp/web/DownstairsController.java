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


import com.example.studioApp.model.PriorityRepository;
import com.example.studioApp.model.Todo;
import com.example.studioApp.model.TodoRepository;

@Controller
public class DownstairsController {

	@Autowired
	private TodoRepository trepo; 
	
	@Autowired
	private PriorityRepository prepository;
	
	//list of todos for downstairs
	@GetMapping(value = "/downstairs")
	public String downstairs(Model model) {
		model.addAttribute("tasks", trepo.findByPlace("D"));
		return "d/downstairs";
	}
	
	//adding a new todo for downstairs
	@RequestMapping(value="addD")
	public String addTaskD(Model model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("priorities", prepository.findAll());
		return "d/dAddTask";
	}

	//saving new todo
	@PostMapping(value = "saveD")
	public String saveTask(Todo task) {
		trepo.save(task);
		return "redirect:downstairs";
	}
	
	//Deleting only possible for admin users
	@GetMapping(value = "/delete_D/{id}")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTask(@PathVariable("id") Long id, Model model) {
		trepo.deleteById(id);
		return "redirect:/downstairs";
	}
	
	//Editing possible for all users
	@GetMapping(value = "/edit_D/{id}")
	public String editTask(@PathVariable("id") Long id, Model model) {
		model.addAttribute("todo", trepo.findById(id));
		model.addAttribute("priorities", prepository.findAll());
		return "d/dEditTask";
	}
	
}