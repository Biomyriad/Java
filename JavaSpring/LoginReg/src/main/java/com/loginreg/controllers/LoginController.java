package com.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginreg.models.LoginUser;
import com.loginreg.models.User;
import com.loginreg.services.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }    
    
    	User user = userService.register(newUser, result);
    	     
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        session.setAttribute("userId", user.getId());
        return "redirect:/loggedin";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        session.setAttribute("userId", user.getId());
    
        return "redirect:/loggedin";
    }	
    
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		session.setAttribute("userId", null);
	     
	    return "redirect:/";
	}
	
	@GetMapping("/loggedin")
	public String welcome(HttpSession session, Model model) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findUser(userId));
		
	    return "welcome.jsp";
	}	
}
