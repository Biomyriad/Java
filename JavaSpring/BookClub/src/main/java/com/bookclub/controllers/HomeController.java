package com.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookclub.models.BookEntry;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;

@Controller
@RequestMapping("books")
public class HomeController {
	
    @Autowired
    private UserService userService;
	
    @Autowired
    private BookService bookService;
	
	@GetMapping("")
	public String root(HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		model.addAttribute("user", user);
		
		List<BookEntry> entries = bookService.allBooks();
		model.addAttribute("bookEntries", entries);
		
		model.addAttribute("isEdit", false);
		
		return "index.jsp";
	}
	
	@GetMapping("/{id}")
	public String showEntry(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
		model.addAttribute("book", bookService.findBook(id));
		
		return "showbook.jsp";
	}
	
	@GetMapping("/new")
	public String createBook(HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("bookEntry", new BookEntry());
		model.addAttribute("isEdit", false);
		return "bookform.jsp";
	}
	
	@PostMapping("/new")
	public String createBook(HttpSession session, @Valid @ModelAttribute("bookEntry") BookEntry book, BindingResult result) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);

        if (result.hasErrors()) {
            return "bookform.jsp";
        } else {
        	book.setCreator(user);
            BookEntry bookResualtBookEntry = bookService.createBook(book);
            return "redirect:/books/" + bookResualtBookEntry.getId();
        }
		
	}
	
	@GetMapping("/{id}/edit")
	public String editBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}

		model.addAttribute("bookEntry", bookService.findBook(id));
		model.addAttribute("isEdit", true);
		
		return "bookform.jsp";
	}
	
	@PutMapping("/{id}/edit")
	public String editBook(@PathVariable("id") Long id, HttpSession session, @Valid @ModelAttribute("bookEntry") BookEntry book,  BindingResult result) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
        if (result.hasErrors()) {
            return "bookform.jsp";
        } else {
        	book.setCreator(user);
            bookService.updateBook(book);
            return "redirect:/books/" + id;
        }
	}
	
	@DeleteMapping("/{id}/delete")
	@RequestMapping("/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		bookService.deleteBook(id);
		
		return "redirect:/books/";
	}
}
