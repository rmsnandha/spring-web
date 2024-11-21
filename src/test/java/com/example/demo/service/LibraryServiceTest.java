package com.example.demo.service;

import com.example.demo.entity.Library;
import com.example.demo.repository.LibraryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class LibraryServiceTest {

    @InjectMocks
    private LibraryService libraryService; 

    @Mock
    private LibraryRepository libraryRepository; 

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSaveLibrary_shouldReturnLibrary() {
        Library library = new Library();
        library.setName("Test Library");

        when(libraryRepository.save(any(Library.class))).thenReturn(library);

        Library savedLibrary = libraryService.saveLibrary(library);

        assertNotNull(savedLibrary);
        verify(libraryRepository, times(1)).save(library);
    }
}