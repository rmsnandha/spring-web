package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void whenSaveUser_thenReturnUser() {
        Employee user = new Employee();
        user.setUsername("testuser");

        when(userRepository.save(any(Employee.class))).thenReturn(user);

        Employee savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        verify(userRepository, times(1)).save(user);
    }
}