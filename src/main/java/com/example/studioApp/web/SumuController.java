package com.example.studioApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studioApp.model.Todo;
import com.example.studioApp.model.TodoRepositoryS;

@Controller
public class SumuController {

	@Autowired
	private TodoRepositoryS trepos; 
	
	@GetMapping(value = "/sumu")
	public String sumu(Model model) {
		model.addAttribute("tasks", trepos.findAll());
		return "s/sumu";
	}
	
//YOU NEED TO CREATE DIFFERENT ENITIES FOR ALL OF THE REPOS, DOESNT WORK THE WAY I HOPED :(
	
}
