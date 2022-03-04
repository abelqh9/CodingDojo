package com.codingdojo.dojos_y_ninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos_y_ninjas.models.Ninja;
import com.codingdojo.dojos_y_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
	}
}
