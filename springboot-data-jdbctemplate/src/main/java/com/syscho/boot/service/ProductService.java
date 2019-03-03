package com.syscho.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syscho.boot.dao.ProductDao;
import com.syscho.boot.vo.ProductMapper;

/**
 * @author Soni
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public List<ProductMapper> getProducts() {

		return productDao.findAll();
	}

	public ProductMapper getProductById(Long prodId) {

		return productDao.findByProductId(prodId);
	}

	public List<ProductMapper> getProductsByName(String prodName) {

		return productDao.findAllByProductName(prodName);
	}

	public int deleteProdById(long prodId) {

		return productDao.deleteByProductId(prodId);
	}

	public ProductMapper saveProduct(ProductMapper product) {
		int save = productDao.save(product);

		return save > 0 ? product : null;
	}

	public ProductMapper updateProduct(ProductMapper product) {
		return productDao.update(product) > 0 ? product : null;
	}

}
