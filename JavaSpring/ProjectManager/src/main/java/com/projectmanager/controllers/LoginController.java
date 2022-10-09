package com.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectmanager.models.LoginCreds;
import com.projectmanager.models.User;
import com.projectmanager.services.UserService;

@Controller
public class LoginController {
	
    @Autowired
    private UserService userService;
    
	@GetMapping("/login")
	public String login(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginCreds());
		return "login.jsp";
	}
	
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginCreds());
	        return "login.jsp";
	    }    
    
    	User user = userService.register(newUser, result);
    	     
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginCreds());
            return "login.jsp";
        }
        
        session.setAttribute("userId", user.getId());
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginCreds newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
    
        session.setAttribute("userId", user.getId());
    
        return "redirect:/";
    }	
    
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		session.setAttribute("userId", null);
	     
	    return "redirect:/login";
	}		
}
