package com.gonzalo.bikeapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bikeapi.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
    
    Bike findByName(String name);
   List<Bike> findByItems_Type(String type);
   List<Bike> findByManufacturer(String manufacturer);
   List<Bike> findByNameOrderByIdDesc(String name);

}
