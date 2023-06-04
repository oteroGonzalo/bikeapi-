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
		Items item1 = new Items(1L, "123ABC", "PEDALES", "", null);
		Items item2 = new Items(2L, "QWERTY", "CUADRO", "", null);
		Items item3 = new Items(3L, "9874XS", "MANILLAR", "", null);
		Bike bike1 = new Bike(1L, "Road Bike", "A lightweight bike for speed on paved roads", 1499.99, "Specialized",
				List.of(item1, item2));
		Bike bike2 = new Bike(2L, "City Bike", "A comfortable bike for urban commuting", 399.99, "Giant",
				List.of(item2, item3));
		Bike bike3 = new Bike(3L, "City Bike 2000", "A comfortable bike", 500.00, "Giant",
				List.of(item1, item2, item3));
		itemsRepository.save(item1);
		itemsRepository.save(item2);
		itemsRepository.save(item3);
		bikeRepository.save(bike1);
		bikeRepository.save(bike2);
		bikeRepository.save(bike3);
	}

}
