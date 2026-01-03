package com.example.CRUD_Operation;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {

        if (!ValidationUtil.isValidEmail(user.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid email format");
        }

        User createdUser = userService.createUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {

        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

        return ResponseEntity.ok(user);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable UUID id,
            @RequestBody User user) {

        if (!ValidationUtil.isValidEmail(user.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid email format");
        }

        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

        return ResponseEntity.ok(updatedUser);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {

        boolean deleted = userService.deleteUser(id);
        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

        return ResponseEntity.noContent().build();
    }
}
