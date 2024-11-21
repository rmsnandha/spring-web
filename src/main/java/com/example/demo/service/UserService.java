package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public Employee saveUser(Employee employee) {
        return userRepository.save(employee);
    }

    public Employee findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Employee> findAllUsers() {
        return userRepository.findAll();
    }

    public Employee updateUser(Long id, Employee employee) {
        if (userRepository.existsById(id)) {
            employee.setId(id);
            return userRepository.save(employee);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = userRepository.findByUsername(username);
        if (employee == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(employee);
    }
}