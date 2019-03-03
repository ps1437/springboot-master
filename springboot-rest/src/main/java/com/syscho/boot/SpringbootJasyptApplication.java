package com.syscho.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.syscho.boot.service.ProductService;
import com.syscho.boot.vo.Product;

@SpringBootApplication
public class SpringbootJasyptApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJasyptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.saveProduct(new Product("Jeans", 800, "Mens Wear"));
		productService.saveProduct(new Product("Shirt", 1000, "Mens Wear"));
		productService.saveProduct(new Product("Skirt", 750, "Ladies Wear"));
	}
}
