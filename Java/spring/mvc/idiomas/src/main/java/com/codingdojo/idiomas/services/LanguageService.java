package com.codingdojo.idiomas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.idiomas.models.Language;
import com.codingdojo.idiomas.repositories.LanguageRepository;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    
    public Language createLanguage(Language e) {
        return languageRepository.save(e);
    }
    
    public Language findLanguage(Long id) {
    	Optional<Language> optionalLanguage = languageRepository.findById(id);
    	if(optionalLanguage.isPresent()) {
    		return optionalLanguage.get();
    	} else {
    		return null;
    	}
    }
    
    public Language updateLanguage(Language expenseWithNewData) {
        return languageRepository.save(expenseWithNewData);
    }
    
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
    
}