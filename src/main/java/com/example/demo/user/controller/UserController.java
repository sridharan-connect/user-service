package com.example.demo.user.controller;

import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.model.ApiResponse;
import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<UserDTO>>> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(
                new ApiResponse<>("Users fetched successfully",
                        userService.getAllUsers(name, page, size, sortBy))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUser(@PathVariable Integer id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(
                new ApiResponse<>("User fetched successfully", user)
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("User created successfully", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok(
                new ApiResponse<>("User updated successfully", null)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}