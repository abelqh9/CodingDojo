package com.codingdojo.dojos_y_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos_y_ninjas.models.Dojo;
import com.codingdojo.dojos_y_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo getDojo(Long id){
		Optional<Dojo> result = dojoRepository.findById(id);
		if ( result.isPresent() ) {
			return result.get();
		}else {
			return null;
		}
	}
}
