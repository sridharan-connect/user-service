package com.example.demo.user.service;

import com.example.demo.user.dto.UserDTO;
import com.example.demo.common.exception.AppException;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_ALREADY_EXISTS = "User already exists";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserDTO> getAllUsers(String name, int page, int size, String sortBy) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<User> userPage;
        if (name != null && !name.isEmpty()) {
            userPage = userRepository.findByNameContainingIgnoreCase(name, pageable);
        } else {
            userPage = userRepository.findAll(pageable);
        }
        logger.info("User Data Fetching for page: {}, size: {}, sortBy: {}", page, size, sortBy);
        return userPage.map(user -> new UserDTO(user.getId(), user.getName()));
    }

    @Cacheable(value = "users", key = "#id")
    public UserDTO getUserById(Integer id) {
        System.out.println("Fetching from DB...");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(USER_NOT_FOUND, HttpStatus.NOT_FOUND));
        logger.info("User Data Fetched Succesfully for userid : {}",id);
        return new UserDTO(user.getId(), user.getName());
    }

    public void createUser(User user) {
        if (userRepository.existsById(user.getId())) {
            logger.warn("User already exists with id: {}", user.getId());
            throw new AppException(USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        logger.info("Added user with id: {}", user.getId());
    }

    @CacheEvict(value = "users", key = "#id")
    public void updateUser(Integer id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException(USER_NOT_FOUND, HttpStatus.NOT_FOUND));
        existingUser.setName(user.getName());
        userRepository.save(existingUser);
        logger.info("Updated user with id: {}", user.getId());
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new AppException(USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        logger.info("Deleted user with id: {}",id);
    }
}