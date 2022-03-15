package com.codingdojo.productos_y_categorias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productos_y_categorias.models.Category;
import com.codingdojo.productos_y_categorias.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Optional<Product> findById(Long id);

    List<Product> findAllByCategories(Category category);
    
    List<Product> findAllByCategoriesNotContains(Category category);
}
