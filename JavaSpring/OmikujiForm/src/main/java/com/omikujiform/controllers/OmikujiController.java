package com.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/omikuji";
	}
	
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/submitted")
	public String process(HttpSession session,
			@RequestParam("number") int number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("endeavor") String endeavor,
			@RequestParam("thing") String thing,
			@RequestParam("message") String message) {
		
		String fortune = String.format(
				"In %s years you will live in %s with %s as your roommate, "
				+ "%s. The next time you see a %s, you will "
				+ "have good luck. Also, %s.",
				number, city, person, endeavor, thing, message);
				
		session.setAttribute("fortune", fortune);
		
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String submit(Model model, HttpSession session) {
		
		String fortune = (String) session.getAttribute("fortune");
		model.addAttribute("fortune", fortune);
		
		return "fortune.jsp";
	}
	
}
