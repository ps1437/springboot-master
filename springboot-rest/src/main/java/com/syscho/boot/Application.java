package com.syscho.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.syscho.boot.entity.ProductEntity;
import com.syscho.boot.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class Application implements CommandLineRunner {

	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("adding 3 product to product table ");

		productService.saveProduct(new ProductEntity("Jeans", 800, "Mens Wear"));
		productService.saveProduct(new ProductEntity("Shirt", 1000, "Mens Wear"));
		productService.saveProduct(new ProductEntity("Skirt", 750, "Ladies Wear"));

		log.info("product added successfully !!");
	}
}
