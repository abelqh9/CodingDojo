package com.codingdojo.productos_y_categorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.productos_y_categorias.models.Category;
import com.codingdojo.productos_y_categorias.models.Product;
import com.codingdojo.productos_y_categorias.repositories.ProductRepository;

@Service
public class ProductService {
	
	final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product createProduct(Product newProduct, BindingResult result){
		
		if( !result.hasErrors() ) {
			return this.productRepository.save(newProduct);
		}else {
			return null;
		}
	}
	
	public void saveProduct(Product product){
		this.productRepository.save(product);
	}
	
	public Product getProductById(Long id){
		Optional<Product> result = this.productRepository.findById(id);
		
		if( result.isPresent() ) {
			return result.get();
		}else {
			return null;
		}
	}
	
	public List<Product> getCategoryProducts(Category category){
		return this.productRepository.findAllByCategories(category);
	}
	
	public List<Product> getNotCategoryProducts(Category category){
		return this.productRepository.findAllByCategoriesNotContains(category);
	}

}