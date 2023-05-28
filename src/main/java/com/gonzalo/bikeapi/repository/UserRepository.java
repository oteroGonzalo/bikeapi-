package com.gonzalo.bikeapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bikeapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findByUsername(String username);
}