package com.languages.controllers;

import java.util.List;

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

import com.languages.models.Language;
import com.languages.services.LanguageService;

@Controller
public class HomeController {
	
    @Autowired
    LanguageService languageService;
	
    @GetMapping("/")
    public String index() {
        return "redirect:/languages";
    }
    
    @GetMapping("/languages")
    public String home(Model model, @ModelAttribute("language") Language language, BindingResult result) {

	    List<Language> languages = languageService.allLanguages();
	    model.addAttribute("languages", languages);
    	
        return "index.jsp";
    }
    
    @PostMapping("/languages")
    public String create(Model model, @Valid @ModelAttribute("language") Language language, 
			BindingResult result) {
    	
        if (result.hasErrors()) {
    	    List<Language> languages = languageService.allLanguages();
    	    model.addAttribute("languages", languages);
            return "index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }    
    
    @GetMapping("/languages/{id}/edit")
    public String edit(Model model,  @PathVariable("id") Long id) {
    	
	    Language language = languageService.findLanguage(id);
	    model.addAttribute("language", language);
    	
        return "edit.jsp";
    }  
    
    @PutMapping("/languages/{id}")
    public String update(Model model, @Valid @ModelAttribute("language") Language language, 
						BindingResult result) {
    	
        if (result.hasErrors()) {
    	    List<Language> languages = languageService.allLanguages();
    	    model.addAttribute("languages", languages);
            return "edit.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }    
    
    @GetMapping("/languages/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
    	
	    Language language = languageService.findLanguage(id);
	    model.addAttribute("language", language);
    	
        return "show.jsp";
    }
    
    @DeleteMapping("/languages/{id}/delete")
    @RequestMapping("/languages/{id}/delete")  // allows for the use of a <a> tag to be used to delete
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
