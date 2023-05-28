package com.gonzalo.bikeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bikeapi.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>  {
    
}
