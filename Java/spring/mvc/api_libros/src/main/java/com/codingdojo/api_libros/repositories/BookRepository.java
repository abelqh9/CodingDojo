package com.codingdojo.api_libros.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.api_libros.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
    // GET
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
    
    // COUNT
    Long countByTitleContaining(String search);
    
    // DELETE
    Long deleteByTitleStartingWith(String search);
}
