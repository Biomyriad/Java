package com.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookclub.models.BookEntry;

@Repository
public interface BookRepository extends CrudRepository<BookEntry, Long> {
	
	List<BookEntry> findAll();

}
