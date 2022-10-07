package com.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productsRepository;
	
	public List<Product> allProducts() {
		return productsRepository.findAll();
	}
	
	public Product createProduct(Product p) {
		return productsRepository.save(p);
	}
	
	public Product updateProduct(Product p) {
		return productsRepository.save(p);
	}
	
	public Product findProduct(long id) {
		return productsRepository.findById(id).orElse(null);		
	}
	
	public List<Product> getAssignedCategories(Category category){
		return productsRepository.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedCategories(Category category){
		return productsRepository.findByCategoriesNotContains(category);
	}

}
