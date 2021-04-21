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
import com.example.studioApp.model.PresentRepository;

@Controller
public class HomeController {

	@Autowired
	private PresentRepository prepo;

	// controller for home page
	// Three different spaces, own controllers for each page
	@GetMapping(value = "/home")
	public String Present(Model model) {
		model.addAttribute("people", prepo.findAll());
		return "h/home";
	}

	@RequestMapping(value = "addH")
	public String addPresent(Model model) {
		model.addAttribute("present", new Present());
		return "h/hAddPresent";
	}

	// VARIABLE NAMES TASK VS TODO FIGURE IT OUT what is the best way
	@PostMapping(value = "saveH")
	public String savePresent(Present present, Model model) {
		prepo.save(present);
		return "redirect:home";
	}

	@GetMapping(value = "/delete_H/{id}")
	public String deletePresent(@PathVariable("id") Long id, Model model) {
		prepo.deleteById(id);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public @ResponseBody List<Present> whoIsPresentRest() {
		return (List<Present>) prepo.findAll();
	}
	
	@RequestMapping(value="/present/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Present> FindWhoIsPresentRest(@PathVariable("id") Long id) {
		return prepo.findById(id);
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}
