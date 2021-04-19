package com.example.studioApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studioApp.model.TodoRepository;
import com.example.studioApp.model.Todo;

@Controller
public class SumuController {

	@Autowired
	private TodoRepository trepo; 
	
	@GetMapping(value = "/sumu")
	public String sumu(Model model) {
		model.addAttribute("tasks", trepo.findByPlace("S"));
		return "s/sumu";
	}
	
	@RequestMapping(value="addS")
	public String addTaskS(Model model) {
		model.addAttribute("todo", new Todo());
		return "s/sAddTask";
	}
	
	@PostMapping(value = "saveS")
	public String saveTask(Todo task) {
		trepo.save(task);
		return "redirect:sumu";
	}
//TODO YOU NEED TO CREATE DIFFERENT ENITIES FOR ALL OF THE REPOS, DOESNT WORK THE WAY I HOPED :( 
	
}
