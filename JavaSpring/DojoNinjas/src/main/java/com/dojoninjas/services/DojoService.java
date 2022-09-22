package com.dojoninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoninjas.models.Dojo;
import com.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepository;
	   
    // returns all the books
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a book
    public Dojo create(Dojo d) {
        return dojoRepository.save(d);
    }
	
    public Dojo findById(Long id) {
    	return dojoRepository.findById(id).orElse(null);
	}
	
}
