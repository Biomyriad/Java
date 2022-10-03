package com.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.BookEntry;
import com.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
    public List<BookEntry> allBooks() {
        return bookRepository.findAll();
    }
    
    public BookEntry findBook(Long id) {
		return bookRepository.findById(id).orElse(null);
    }
    
    public BookEntry createBook(BookEntry b) {
        return bookRepository.save(b);
    }
    
    public BookEntry updateBook(BookEntry b) {
        return bookRepository.save(b);
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
	
}
