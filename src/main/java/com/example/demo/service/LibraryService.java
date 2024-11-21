package com.example.demo.service;

import com.example.demo.entity.Library;
import com.example.demo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;
    
    @Cacheable("libraries")
    public List<Library> findAllLibraries() {
        return libraryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Library> findLibraryById(Long id) {
        return libraryRepository.findById(id);
    }

    @Transactional
    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Transactional
    public void deleteLibraryById(Long id) {
        libraryRepository.deleteById(id);
    }
}