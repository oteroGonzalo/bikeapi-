package com.gonzalo.bikeapi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String name;
    private String description;
    private double price;
    private String manufacturer;

    @ManyToMany
    @JoinTable(name = "items_bike", joinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"),
     inverseJoinColumns = @JoinColumn(name="bike_id", referencedColumnName = "id"))
    private List<Items> items;
}
