package com.codingdojo.productos_y_categorias.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productos_y_categorias.models.Category;
import com.codingdojo.productos_y_categorias.models.Product;
import com.codingdojo.productos_y_categorias.services.CategoryService;
import com.codingdojo.productos_y_categorias.services.ProductService;

@Controller
public class CategoriesController {
	
	final ProductService productService;
	final CategoryService categoryService;
	
	public CategoriesController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	
	
	@GetMapping("/categories/new")
	public String showNewCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String NewCategory(Model model, @Valid @ModelAttribute("category") Category category, BindingResult result) {
		
		Category createResult = this.categoryService.createCategory(category, result);
		
		if ( createResult != null ) {
			return "redirect:/categories/"+createResult.getId();
		}else {
			return "newCategory.jsp";			
		}
		
	}
	
	
	
	@GetMapping("/categories/{category_id}")
	public String showProduct(@PathVariable("category_id") Long category_id,  Model model) {
		
		Category category = this.categoryService.getCategoryById(category_id);
		List<Product> categoryProducts = this.productService.getCategoryProducts(category);
		List<Product> notCategoryProducts = this.productService.getNotCategoryProducts(category);
		
		model.addAttribute("category", category);
		model.addAttribute("categoryProducts", categoryProducts);
		model.addAttribute("notCategoryProducts", notCategoryProducts);
		
		return "showCategory.jsp";
	}
	@PostMapping("/categories/{category_id}")
	public String addProduct(@PathVariable("category_id") Long category_id, @RequestParam("newProduct") Long product_id,  Model model) {
		
		Product product = this.productService.getProductById(product_id);
		Category category = this.categoryService.getCategoryById(category_id);
		
		category.getProducts().add(product);
		
		this.categoryService.saveCategory(category);
		
		return "redirect:/categories/"+category_id;
	}

}
