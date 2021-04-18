package com.example.studioApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	
	//controller for home page
	//Three different spaces, own controllers for each page
	@RequestMapping(value = "/home")
	public String Todo(Model model) {
		return "home";
	}

}
