package com.codingdojo.corredor_de_libros.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codingdojo.corredor_de_libros.models.Borrow;
import com.codingdojo.corredor_de_libros.models.User;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long>{
	
	List<Borrow> findAll();

	Optional<Borrow> findById(Long id);
	
	Optional<Borrow> findByUser(User user);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM borrows WHERE borrows.book_id = :book_id_param", nativeQuery=true)
	void delete_ByBookId(@Param("book_id_param") Long book_id);
}
