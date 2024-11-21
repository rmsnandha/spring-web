package com.example.demo.repository;

import com.example.demo.entity.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    public void whenSave_thenFindById() {
        Library library = new Library();
        library.setName("Test Library");

        Library savedLibrary = libraryRepository.save(library);
        Library fetchedLibrary = libraryRepository.findById(savedLibrary.getId()).orElse(null);

        assertNotNull(fetchedLibrary);
        assertEquals(savedLibrary.getName(), fetchedLibrary.getName());
    }
}