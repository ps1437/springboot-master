package com.syscho.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.syscho.boot.service.ProductService;
import com.syscho.boot.vo.ProductMapper;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductMapper> prodList = productService.getProducts();

		for (ProductMapper product : prodList) {
			System.out.println(product.getPRODUCT_ID() + ": " + product.getPRODUCT_NAME());
		}

	}
}
