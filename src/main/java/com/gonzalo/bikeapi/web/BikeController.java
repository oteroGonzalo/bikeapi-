package com.gonzalo.bikeapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalo.bikeapi.entity.Bike;
import com.gonzalo.bikeapi.service.BikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bikes")
@Tag(name = "Bike Controller")
public class BikeController {
    @Autowired
    BikeService bikeService;

    @Cacheable("bikes")
    @Operation(summary = "Retrieve bikes by name")
    @GetMapping("/{name}")
    public ResponseEntity<Bike> findByName(@PathVariable String name) {
        Bike bike = bikeService.findByName(name);
        if (bike != null) {
            return new ResponseEntity<Bike>(bikeService.findByName(name), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Operation(summary = "Retrieve bikes by item type")
    @GetMapping("/itemtype/{typeId}")
    public ResponseEntity<List<Bike>> findByItemType(@PathVariable String typeId) {
        return new ResponseEntity<List<Bike>>(bikeService.findByItemType(typeId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve bikes by manufacturer")
    @GetMapping("/manufacturer/{manufacturerId}")
    public ResponseEntity<List<Bike>> findByManufacturer(@PathVariable String manufacturerId) {
        return new ResponseEntity<List<Bike>>(bikeService.findByManufacturer(manufacturerId), HttpStatus.OK);
    }

    @Operation(summary = "Creates a bike", description = "Only the name of the bike is required")
    @PostMapping
    public ResponseEntity<Bike> saveBike(@Valid @RequestBody Bike bike) {
        return new ResponseEntity<Bike>(bikeService.saveBike(bike), HttpStatus.CREATED);
    }

    @Operation(summary = "Adds item to bike")
    @PutMapping("/{bikeId}/item/{itemId}")
    public ResponseEntity<Bike> addItemToBike(@PathVariable Long bikeId, @PathVariable Long itemId) {
        return new ResponseEntity<Bike>(bikeService.addItemToBike(bikeId, itemId), HttpStatus.OK);
    }

}
