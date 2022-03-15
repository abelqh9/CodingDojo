package com.codingdojo.corredor_de_libros.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.corredor_de_libros.models.Book;
import com.codingdojo.corredor_de_libros.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findById(Long id);
	
	Optional<User> findByEmail(String email);
	
	@Query(value="SELECT books.id, books.author, books.created_at, books.thoughts, books.title, books.updated_at, books.user_id FROM users JOIN borrows ON users.id = borrows.user_id JOIN books ON borrows.book_id = books.id WHERE users.id = :user_id_param", nativeQuery=true)
	List<Book> find_AllBooksBorrowingByUser(@Param("user_id_param") Long id);
}
