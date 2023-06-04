package com.gonzalo.bikeapi.service;

import java.util.List;

import com.gonzalo.bikeapi.entity.Items;

public interface ItemsService {
    List<Items> getItems();
    Items saveItem(Items item);

}
