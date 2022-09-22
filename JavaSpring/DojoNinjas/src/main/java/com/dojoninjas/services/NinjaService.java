package com.dojoninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoninjas.models.Ninja;
import com.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepository;
	
    // returns all the books
    public List<Ninja> allDojos() {
        return ninjaRepository.findAll();
    }
    // creates a book
    public Ninja create(Ninja d) {
        return ninjaRepository.save(d);
    }

}
