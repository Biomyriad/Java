package com.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookclub.models.BookEntry;
import com.bookclub.models.LoginCreds;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;

@Controller
public class LoginController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private BookService bookService;
	
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
        return "redirect:/books";
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
    
        return "redirect:/books";
    }	
    
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		session.setAttribute("userId", null);
	     
	    return "redirect:/login";
	}	
	
//	@GetMapping("/loggedin")
//	public String welcome(HttpSession session, Model model) {
//	 
//		if(session.getAttribute("userId") == null) {
//			return "redirect:/logout";
//		}
//		
//		Long userId = (Long) session.getAttribute("userId");
//		User user = userService.findUser(userId);
//		model.addAttribute("user", user);
//		
////		BookEntry bookEntry = new BookEntry();
////		
////		bookEntry.setTitle("first Title");
////		bookEntry.setAuthorName("my Author");
////		bookEntry.setThoughts("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
////		bookEntry.setCreator(user);
////		
////		bookService.createBook(bookEntry);
//		
//	    return "index.jsp";
//	}
}
