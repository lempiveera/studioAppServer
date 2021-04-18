package com.example.studioApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.studioApp.model.TodoRepositoryD;
import com.example.studioApp.model.Todo;

@Controller
public class DownstairsController {

	@Autowired
	private TodoRepositoryD trepod; 
	
	//controller for downstairs page, need a controller for everypage cause thymeleaf be like that
	//GetMapping = RequestMapping(value="/downstairs, method = RequestMethpod.GET), works the same way with POST etc.
	@GetMapping(value = "/downstairs")
	public String downstairs(Model model) {
		model.addAttribute("tasks", trepod.findAll());
		//model.addAttribute("events", erepo.findAll()); HOW TO HANDLE DATE?
		return "d/downstairs";
	}
	
	@RequestMapping(value="add")
	public String addDTask(Model model) {
		model.addAttribute("todo", new Todo());
		return "d/dAddTask";
	}

	//VARIABLE NAMES TASK VS TODO FIGURE IT OUT what is the best way
	@PostMapping(value = "save")
	public String saveDTask(Todo task) {
		trepod.save(task);
		return "redirect:downstairs";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteDTask(@PathVariable("id") Long id, Model model) {
		trepod.deleteById(id);
		return "redirect:/downstairs";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("todo", trepod.findById(id));
		return "d/dEditTask";
	}
}
