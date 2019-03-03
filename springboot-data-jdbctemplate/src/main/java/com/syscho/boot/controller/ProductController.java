package com.syscho.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syscho.boot.service.ProductService;
import com.syscho.boot.vo.ProductMapper;

/**
 * @author Soni
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PutMapping("/save")
	public ProductMapper saveProduct(ProductMapper product) {
		return productService.saveProduct(product);
	}

	@PostMapping("/update")
	public ProductMapper updateProduct(@RequestBody ProductMapper product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public int deleteProdById(@PathVariable("id") long prodId) {
		return productService.deleteProdById(prodId);
	}

	@GetMapping("/view/search/id/{id}")
	public ProductMapper getProductById(@PathVariable("id") long prodId) {
		return productService.getProductById(prodId);
	}

	@GetMapping("/view/search/name/{name}")
	public List<ProductMapper> getProductsByName(@PathVariable("name") String prodName) {
		return productService.getProductsByName(prodName);
	}

	@GetMapping("/view")
	public List<ProductMapper> getProducts() {
		return productService.getProducts();
	}

}
