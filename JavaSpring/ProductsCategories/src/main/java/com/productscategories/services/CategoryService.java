package com.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository caregoryRepository;

	public List<Category> allCategories(){
		return caregoryRepository.findAll();
	}
	
	public Category createCategory(Category c) {
		return caregoryRepository.save(c);
	}
	
	public Category updateCategory(Category c) {
		return caregoryRepository.save(c);
	}
	
	public Category findCategory(long id) {
		return caregoryRepository.findById(id).orElse(null);		
	}
	
	public List<Category> getAssignedProducts(Product product){
		return caregoryRepository.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedProducts(Product product){
		return caregoryRepository.findByProductsNotContains(product);
	}
	
}
