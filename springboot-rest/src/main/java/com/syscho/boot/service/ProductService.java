package com.syscho.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syscho.boot.entity.ProductEntity;
import com.syscho.boot.repo.ProductRepository;

/**
 * @author Soni
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productDao;

	public List<ProductEntity> getProducts() {

		return productDao.findAll();
	}

	public ProductEntity getProductById(Long prodId) {

		return productDao.findByProductId(prodId);
	}

	public List<ProductEntity> getProductsByName(String prodName) {

		return productDao.findAllByProductName(prodName.toLowerCase());
	}

	public int deleteProdById(long prodId) {

		return productDao.deleteByProductId(prodId);
	}

	public ProductEntity saveProduct(ProductEntity product) {

		return productDao.save(product);
	}

	public ProductEntity updateProduct(ProductEntity product) {
		return productDao.save(product);
	}

}
