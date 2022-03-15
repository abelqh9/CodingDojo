package com.codingdojo.inicio_de_sesion_y_registro.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.inicio_de_sesion_y_registro.models.LoginUser;
import com.codingdojo.inicio_de_sesion_y_registro.models.User;
import com.codingdojo.inicio_de_sesion_y_registro.repositories.UserRepository;

@Service
public class UserService {

	final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getUserById(Long id) {
		Optional<User> result = this.userRepository.findById(id);
		
		if( result.isPresent() ){
			return result.get();
		}else {
			return null;
		}
	}
	
	public User getUserByEmail(String email) {
		Optional<User> result = this.userRepository.findByEmail(email);
		
		if( result.isPresent() ){
			return result.get();
		}else {
			return null;
		}
	}
	
	public User register(User newUser, BindingResult result) {
		
		if( this.getUserByEmail(newUser.getEmail()) != null) {
			result.rejectValue("email", "Matches", "The email already exist in the db!");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		
        if(result.hasErrors()) {
        	return null;
        }
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		
		newUser.setPassword(hashed);
		
		return this.userRepository.save(newUser);
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		User userInDb = this.getUserByEmail(newLoginObject.getEmail());
        
		if( userInDb == null) {
			result.rejectValue("email", "Matches", "The email don´t exist in the db!");
		}else {
			if(!BCrypt.checkpw(newLoginObject.getPassword(), userInDb.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid Password!");
				return null;
			}
		}
		
		return userInDb;
	}
}
