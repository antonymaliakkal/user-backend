package com.ust.wastewarden.users.controller;

import com.ust.wastewarden.users.dto.UserDto;
import com.ust.wastewarden.users.model.User;
import com.ust.wastewarden.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return userService.createUser(userDto);
    }

    // Update a user
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto updatedUser) {
//        try {
//            return ResponseEntity.ok(userService.updateUser(id, updatedUser));
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto updatedUser) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, updatedUser));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


        // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted");
    }
}
