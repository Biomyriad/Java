package com.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @PostMapping("/create")
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
    	
    }
    
    @RequestMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
	    
	    Expense expense = travelsService.findBook(id);
	    model.addAttribute("expense", expense);    	

        return "show.jsp";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
	    
	    Expense expense = travelsService.findBook(id);
	    model.addAttribute("expense", expense);    	

        return "edit.jsp";
    }

	@PutMapping("/edit/{id}")
	public String edit(Model model, 
						@PathVariable("id") Long id,
						@ModelAttribute("expense") @Valid Expense expense, 
						BindingResult result) {
		
	    if (result.hasErrors()) {
	        return "edit.jsp";
	    } else {
	    	travelsService.updateExpense(expense);
	        return "redirect:/";
	    }
	}   
	
    @DeleteMapping("/delete/{id}")
    @RequestMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	travelsService.deleteExpense(id);
        return "redirect:/";
    }
}
