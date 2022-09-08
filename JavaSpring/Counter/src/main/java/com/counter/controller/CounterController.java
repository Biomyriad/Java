package com.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CounterController {
	
    @RequestMapping("")
    public String index(HttpSession session) {
    	
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			session.setAttribute("count", (int) session.getAttribute("count") + 1);
		}
		return "index.jsp";
    	
    }
    
    @RequestMapping("/counter")
    public String counter(Model model, HttpSession session) {
        
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "count.jsp";
    }
    
    @RequestMapping("/reset")
    public String reset(Model model, HttpSession session) {
        
    	session.setAttribute("count", 0);
		return "index.jsp";
    }
    
}
