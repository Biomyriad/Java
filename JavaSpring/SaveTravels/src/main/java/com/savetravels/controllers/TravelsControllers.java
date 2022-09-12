package com.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.savetravels.models.Expense;
import com.savetravels.services.TravelsService;

@Controller
public class TravelsControllers {
	
    @Autowired
    TravelsService travelsService;
	
    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("newExpense") Expense newExpense) {

	    List<Expense> expense = travelsService.allBooks();
	    model.addAttribute("expense", expense);
	    
        return "index.jsp";
    }
    
    @RequestMapping("/create")
    public String create(Model model, @Valid @ModelAttribute("newExpense") Expense newExpense, 
            			BindingResult result) {
    	
	    List<Expense> expense = travelsService.allBooks();
	    model.addAttribute("expense", expense);
	    
        if (result.hasErrors()) {
        	return "index.jsp";
        } else {
        	travelsService.createTravel(newExpense);
        	return "redirect:/";
        }
    	
    	//return "redirect:/";
    }
}
