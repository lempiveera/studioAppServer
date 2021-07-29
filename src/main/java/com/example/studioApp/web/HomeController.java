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

	//Home page controller. Contains links to all the locations, 
	//and a list of people currently at studios/sumu
	
	@Autowired
	private PresentRepository prepo;

	
	@GetMapping(value = "/home")
	public String Present(Model model) {
		model.addAttribute("people", prepo.findAll());
		return "h/home";
	}

	//for creating a new Present = a new person who is currently there
	@RequestMapping(value = "addH")
	public String addPresent(Model model) {
		model.addAttribute("present", new Present());
		return "h/hAddPresent";
	}

	// Saving a new person to the currently here list
	@PostMapping(value = "saveH")
	public String savePresent(Present present, Model model) {
		prepo.save(present);
		return "redirect:home";
	}
	
	//deleting a person from currently here list, all users can delete persons
	@GetMapping(value = "/delete_H/{id}")
	public String deletePresent(@PathVariable("id") Long id, Model model) {
		prepo.deleteById(id);
		return "redirect:/home";
	}
	
	//REST
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public @ResponseBody List<Present> whoIsPresentRest() {
		return (List<Present>) prepo.findAll();
	}
	
	//REST
	@RequestMapping(value="/present/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Present> FindWhoIsPresentRest(@PathVariable("id") Long id) {
		return prepo.findById(id);
	}

	//for login page
//	@RequestMapping(value = "/login")
//	public String login() {
//		return "login";
//	}
	
}
