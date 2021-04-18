package com.example.studioApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SumuController {

	@GetMapping(value = "/sumu")
	public String sumu(Model model) {
		return "s/sumu";
	}
}
