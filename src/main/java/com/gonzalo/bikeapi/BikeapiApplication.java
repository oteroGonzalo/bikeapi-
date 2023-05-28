package com.gonzalo.bikeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gonzalo.bikeapi.entity.Bike;
import com.gonzalo.bikeapi.repository.BikeRepository;

@SpringBootApplication
@EnableCaching
public class BikeapiApplication implements CommandLineRunner {
	@Autowired
	BikeRepository bikeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BikeapiApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		Bike bike1 = new Bike(1L, "Mountain Bike", "A sturdy bike for off-road adventures", 599.99, "Trek", null);
		Bike bike2 = new Bike(2L, "Road Bike", "A lightweight bike for speed on paved roads", 1499.99, "Specialized", null);
		Bike bike3 = new Bike(3L, "City Bike", "A comfortable bike for urban commuting", 399.99, "Giant", null);
		Bike bike4 = new Bike(4L, "City Bike 2000", "A comfortable bike", 500.00, "Giant", null);

		// Save the bikes to the repository
		bikeRepository.save(bike1);
		bikeRepository.save(bike2);
		bikeRepository.save(bike3);
		bikeRepository.save(bike4);


		System.out.println("Bikes created and saved successfully!");
	}

}
