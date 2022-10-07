package com.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.services.CategoryService;
import com.productscategories.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired 
	CategoryService categoryService;
	
	@GetMapping("/")
	public String root(Model model) {
		
		System.out.println("P " + productService.allProducts().size()); 
		System.out.println("C " + categoryService.allCategories().size());
		
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProducts(@ModelAttribute("newProduct") Product product) {
		
		return "new-product.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProducts(@Valid @ModelAttribute("newProduct") Product product, BindingResult result) {
		
        if (result.hasErrors()) {
            return "new-product.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/";
        }
	}
	
	@GetMapping("/categories/new")
	public String newCategories(@ModelAttribute("newCategory") Category category) {
		
		return "new-category.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newCategories(@Valid @ModelAttribute("newCategory") Category category, BindingResult result) {
		
        if (result.hasErrors()) {
            return "new-category.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/";
        }
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		
// product.getCategories() also contain AssignedCategories!!
		System.out.println(product.getCategories().size());
		
		model.addAttribute("catAssigned", categoryService.getAssignedProducts(product));
		model.addAttribute("catUnassigned", categoryService.getUnassignedProducts(product));
		
		return "products.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId,  Model model) {
		
		Product product = productService.findProduct(id);
		Category category = categoryService.findCategory(catId);
		
		product.getCategories().add(category);
		productService.updateProduct(product);
		
		return "redirect:/products/" + id;
	}	
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		
// category.getProducts() also contain AssignedProducts!!
		System.out.println(category.getProducts().size());
		
		model.addAttribute("prodAssigned", productService.getAssignedCategories(category));
		model.addAttribute("prodUnassigned", productService.getUnassignedCategories(category));
		
		return "categories.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String editCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
		
		Category category = categoryService.findCategory(id);
		Product product = productService.findProduct(productId);
		
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		
		return "redirect:/categories/" + id;
	}
}
