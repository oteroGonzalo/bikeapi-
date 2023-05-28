package com.gonzalo.bikeapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gonzalo.bikeapi.entity.Bike;
import com.gonzalo.bikeapi.entity.Items;
import com.gonzalo.bikeapi.repository.BikeRepository;
import com.gonzalo.bikeapi.repository.ItemsRepository;

@SpringBootApplication
@EnableCaching
public class BikeapiApplication implements CommandLineRunner {
	@Autowired
	BikeRepository bikeRepository;
	@Autowired
	ItemsRepository itemsRepository;

	public static void main(String[] args) {
		SpringApplication.run(BikeapiApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		Bike bike1 = new Bike(1L, "Road Bike", "A lightweight bike for speed on paved roads", 1499.99, "Specialized",
				null);
		Bike bike2 = new Bike(2L, "City Bike", "A comfortable bike for urban commuting", 399.99, "Giant", null);
		Bike bike3 = new Bike(3L, "City Bike 2000", "A comfortable bike", 500.00, "Giant", null);
		bikeRepository.save(bike1);
		bikeRepository.save(bike2);
		bikeRepository.save(bike3);

	}

}
