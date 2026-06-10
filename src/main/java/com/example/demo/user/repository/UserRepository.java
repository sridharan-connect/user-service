package com.example.demo.user.repository;

import com.example.demo.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//save(), findAll() ,findById() ,existsById() ,deleteById()
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}