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
public class ProductsController {

	final ProductService productService;
	final CategoryService categoryService;
	
	public ProductsController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		model.addAttribute("product", new Product());
		
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String NewProduct(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		Product createResult = this.productService.createProduct(product, result);
		
		if ( createResult != null ) {
			return "redirect:/products/"+createResult.getId();
		}else {
			return "newCategory.jsp";
		}
		
	}
	
	@GetMapping("/products/{product_id}")
	public String showProduct(@PathVariable("product_id") Long product_id,  Model model) {
		
		Product product = this.productService.getProductById(product_id);
		List<Category> productCategories = this.categoryService.getProductCategories(product);
		List<Category> notProductCategories = this.categoryService.getNotProductCategories(product);
		
		model.addAttribute("product", product);
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("notProductCategories", notProductCategories);
		
		return "showProduct.jsp";
	}
	@PostMapping("/products/{product_id}")
	public String addCategory(@PathVariable("product_id") Long product_id, @RequestParam("newCategory") Long category_id,  Model model) {
		
		Product product = this.productService.getProductById(product_id);
		Category category = this.categoryService.getCategoryById(category_id);
		
		product.getCategories().add(category);
		
		this.productService.saveProduct(product);
		
		return "redirect:/products/"+product_id;
	}
}
