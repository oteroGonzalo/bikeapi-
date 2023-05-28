package com.gonzalo.bikeapi.service;

import java.util.List;

import com.gonzalo.bikeapi.entity.Bike;

public interface BikeService {
    Bike saveBike(Bike bike);

    Bike findByName(String name);

    List<Bike> findByItemType(String type);

    List<Bike> findByManufacturer(String manufacturer);

    Bike addItemToBike(Long bikeId, Long ItemId);

    

}
