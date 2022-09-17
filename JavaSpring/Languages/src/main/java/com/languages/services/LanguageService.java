package com.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguagesRepository;

@Service
public class LanguageService {

    private final LanguagesRepository languagesRepository;
    public LanguageService(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }
    
    // returns all the books
    public List<Language> allLanguages() {
        return languagesRepository.findAll();
    }
    
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languagesRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public Language createLanguage(Language b) {
        return languagesRepository.save(b);
    }
    
    public Language updateLanguage(Language b) {
        return languagesRepository.save(b);
    }
    
    public void deleteLanguage(Long id) {
    	languagesRepository.deleteById(id);
    }    
}
