package com.gonzalo.bikeapi.service;


import com.gonzalo.bikeapi.entity.User;

public interface UserService {

    User findById(Long userId);
    User saveUser(User user);
    User getUser(String username);
    
}
