package com.gonzalo.bikeapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalo.bikeapi.entity.Items;
import com.gonzalo.bikeapi.service.ItemsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/items")
@Tag(name = "Item Controller")
public class ItemsController {
    @Autowired
    ItemsService itemsService;
    @Operation(summary = "Creates an item", description = "Request Body needs a model and a type")
    @PostMapping
    public ResponseEntity<Items> saveItem(@RequestBody Items item) {
        return new ResponseEntity<Items>(itemsService.saveItem(item), HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieves all items")
    @GetMapping
    public ResponseEntity<List<Items>> getItems() {
        return new ResponseEntity<List<Items>>(itemsService.getItems(), HttpStatus.OK);
    }

}
