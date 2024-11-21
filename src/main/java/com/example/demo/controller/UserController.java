package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Employee> getAllUsers() {
        return userService.findAllUsers();  // Ensure this method exists in UserService
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable Long id) {
        Employee employee = userService.findUserById(id);  // Ensure this method exists in UserService
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @PostMapping
    public Employee createUser(@Validated @RequestBody Employee employee) {
        return userService.saveUser(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateUser(@PathVariable Long id, @Validated @RequestBody Employee employee) {
        Employee updatedEmployee = userService.updateUser(id, employee);  // Ensure this method exists in UserService
        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedEmployee);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);  // Ensure this method exists in UserService
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}