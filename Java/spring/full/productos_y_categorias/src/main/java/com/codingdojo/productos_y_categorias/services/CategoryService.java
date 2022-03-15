package com.codingdojo.productos_y_categorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.productos_y_categorias.models.Category;
import com.codingdojo.productos_y_categorias.models.Product;
import com.codingdojo.productos_y_categorias.repositories.CategoryRepository;

@Service
public class CategoryService {

	final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Category createCategory(Category newCategory, BindingResult result){
		
		if( !result.hasErrors() ) {
			return this.categoryRepository.save(newCategory);
		}else {
			return null;
		}
	}
	
	public void saveCategory(Category category){
		this.categoryRepository.save(category);
	}
	
	public Category getCategoryById(Long id){
		Optional<Category> result = this.categoryRepository.findById(id);
		
		if( result.isPresent() ) {
			return result.get();
		}else {
			return null;
		}
	}
	
	public List<Category> getProductCategories(Product product){
		return this.categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> getNotProductCategories(Product product){
		return this.categoryRepository.findAllByProductsNotContains(product);
	}
}
