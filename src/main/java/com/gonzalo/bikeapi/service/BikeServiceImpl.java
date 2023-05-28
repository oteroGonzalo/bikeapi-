package com.gonzalo.bikeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gonzalo.bikeapi.entity.Bike;
import com.gonzalo.bikeapi.entity.Items;
import com.gonzalo.bikeapi.exception.BikeNotFoundException;
import com.gonzalo.bikeapi.exception.BikeWithItemNotFoundException;
import com.gonzalo.bikeapi.exception.BikeWithManufacturerNotFoundException;
import com.gonzalo.bikeapi.exception.ItemNotFoundException;
import com.gonzalo.bikeapi.repository.BikeRepository;
import com.gonzalo.bikeapi.repository.ItemsRepository;

@Service
public class BikeServiceImpl implements BikeService {
    @Autowired
    BikeRepository bikeRepository;
    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public Bike saveBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Cacheable("bike")
    public Bike findByName(String name) {

        return bikeRepository.findByName(name);

    }

    @Override
    @Cacheable("bikeList")
    public List<Bike> findByItemType(String type) {

        List<Bike> bikes = bikeRepository.findByItems_Type(type);

        if (bikes.isEmpty()) {
            throw new BikeWithItemNotFoundException(type);
        }
        return bikes;
    }

    @Override
    @Cacheable("bikeList")
    public List<Bike> findByManufacturer(String manufacturer) {

        List<Bike> bikes = bikeRepository.findByManufacturer(manufacturer);

        if (bikes.isEmpty()) {
            throw new BikeWithManufacturerNotFoundException(manufacturer);
        }
        return bikes;
    }

    public Bike addItemToBike(Long bikeId, Long itemId) {
        Bike bike = bikeRepository.findById(bikeId).orElseThrow(() -> new BikeNotFoundException(bikeId));
        Items item = itemsRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));

        bike.getItems().add(item);
        return bikeRepository.save(bike);

        // return repository.findById(id)
        // .orElseThrow(() -> new EntityNotFoundException(id))

    }
}
