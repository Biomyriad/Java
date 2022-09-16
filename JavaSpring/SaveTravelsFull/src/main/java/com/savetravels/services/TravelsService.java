package com.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.savetravels.models.Expense;
import com.savetravels.repositories.TravelsRepository;

@Service
public class TravelsService {
	
	private final TravelsRepository travelsRepository;
    public TravelsService(TravelsRepository travelsRepository) {
        this.travelsRepository = travelsRepository;
    }
    
    // returns all the books
    public List<Expense> allBooks() {
        return travelsRepository.findAll();
    }
	
    public Expense createTravel(Expense b) {
        return travelsRepository.save(b);
    }
    
	public Expense updateExpense(Expense expense) {
		return travelsRepository.save(expense);
	}
	
    public void deleteExpense(Long id) {
    	travelsRepository.deleteById(id);
    }
    
    public Expense findBook(Long id) {
        Optional<Expense> expense = travelsRepository.findById(id);
        if(expense.isPresent()) {
            return expense.get();
        } else {
            return null;
        }
    }

}
