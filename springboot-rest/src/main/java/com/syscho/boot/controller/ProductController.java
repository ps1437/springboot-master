package com.syscho.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syscho.boot.entity.ProductEntity;
import com.syscho.boot.service.ProductService;

import lombok.AllArgsConstructor;

/**
 * @author Soni
 *
 */
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	private ProductService productService;

	@GetMapping("/{id}")
	public ProductEntity getProductById(@PathVariable("id") long prodId) {
		return productService.getProductById(prodId);
	}

	@GetMapping("/name/{name}")
	public List<ProductEntity> getProductsByName(@PathVariable("name") String prodName) {
		return productService.getProductsByName(prodName);
	}

	@GetMapping
	public List<ProductEntity> getProducts() {
		return productService.getProducts();
	}

	@PutMapping
	public ProductEntity saveProduct(ProductEntity product) {
		return productService.saveProduct(product);
	}

	@PostMapping
	public ProductEntity updateProduct(@RequestBody ProductEntity product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/{id}")
	public int deleteProdById(@PathVariable("id") long prodId) {
		return productService.deleteProdById(prodId);
	}
}
