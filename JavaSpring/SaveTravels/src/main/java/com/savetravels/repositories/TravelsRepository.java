package com.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.savetravels.models.Expense;

@Repository
public interface TravelsRepository extends CrudRepository<Expense, Long>{ 

    List<Expense> findAll();
}
