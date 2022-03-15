package com.codingdojo.productos_y_categorias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productos_y_categorias.models.Category;
import com.codingdojo.productos_y_categorias.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category> findById(Long id);
	
    List<Category> findAllByProducts(Product product);
    
    List<Category> findAllByProductsNotContains(Product product);
}
