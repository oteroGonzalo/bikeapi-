package com.gonzalo.bikeapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonzalo.bikeapi.entity.Items;
import com.gonzalo.bikeapi.repository.BikeRepository;
import com.gonzalo.bikeapi.repository.ItemsRepository;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    BikeRepository bikeRepository;

    public Items saveItem(Items item) {
        return itemsRepository.save(item);
    }

}
