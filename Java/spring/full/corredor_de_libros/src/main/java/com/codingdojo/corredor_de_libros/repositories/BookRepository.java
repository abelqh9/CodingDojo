package com.codingdojo.corredor_de_libros.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.corredor_de_libros.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findAll();

	Optional<Book> findById(Long id);
	
	@Query(value="SELECT * FROM books LEFT JOIN borrows ON books.id = borrows.book_id Where borrows.book_id IS NULL", nativeQuery=true)
	List<Book> find_AllBooksToBorrow();
}
