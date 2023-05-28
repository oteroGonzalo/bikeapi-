package com.gonzalo.bikeapi.entity;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "model", nullable = false)
    @NotBlank
    private String model;
    @Column(name = "type", nullable = false)
    @NotBlank
    private String type;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "items") 
    private List<Bike> bike;
}
