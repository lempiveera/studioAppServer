package com.example.studioApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpstairsController {

	@GetMapping(value = "/upstairs")
	public String upstairs(Model model) {
		return "u/upstairs";
	}
	
	
}
