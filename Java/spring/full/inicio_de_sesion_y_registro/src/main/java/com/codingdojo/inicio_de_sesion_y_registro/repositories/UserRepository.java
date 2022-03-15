package com.codingdojo.inicio_de_sesion_y_registro.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.inicio_de_sesion_y_registro.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findById(Long id);
	
	Optional<User> findByEmail(String email);
	
}
