package com.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoninjas.models.Dojo;
import com.dojoninjas.models.Ninja;
import com.dojoninjas.services.DojoService;
import com.dojoninjas.services.NinjaService;

@Controller
public class HomeController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String home() {
		
		for (Dojo item : dojoService.allDojos()) {
			System.out.println(item.getName());
		}
		
		for (Ninja item : ninjaService.allDojos()) {
			System.out.println(item.getFirstName());
		}
		
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo newDojo) {
		
		for (Dojo item : dojoService.allDojos()) {
			System.out.println(item.getName());
		}
		
		for (Ninja item : ninjaService.allDojos()) {
			System.out.println(item.getFirstName());
		}
		
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {

		System.out.println(newDojo.getName());
        if (result.hasErrors()) {
            return "newdojo.jsp";
        } else {
        	dojoService.create(newDojo);
            return "redirect:/dojos/new";
        }
		
		
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("newNinja") Ninja newNinja) {
		
		model.addAttribute("dojos", dojoService.allDojos());
		
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(Model model,@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result) {

        if (result.hasErrors()) {
            return "newninja.jsp";
        } else {
        	ninjaService.create(newNinja);
            return "redirect:/ninjas/new";
        }
		
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String createDojo(@PathVariable("dojoId") Long dojoId, Model model) {

		//System.out.println(newDojo.getName());
		model.addAttribute("dojo", dojoService.findById(dojoId));
		
		return "dojos.jsp";
	}
	
	
}
