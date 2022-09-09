package com.renderingbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.renderingbooks.models.Book;
import com.renderingbooks.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
    @RequestMapping("")
    public String index(Model model) {

        return "index.jsp";
    }
    
    @RequestMapping("/book/{id}")
    public String book(Model model, @PathVariable("id") long id) {
    	
    	model.addAttribute("id", id);
    	
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
    	
		return "show.jsp";
	}
}