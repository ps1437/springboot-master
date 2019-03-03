package com.syscho.boot.dao;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.syscho.boot.vo.ProductMapper;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public int save(ProductMapper product) {

		String query = "INSERT INTO PRODUCT(PRODUCT_ID,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_DESC) VALUES(?,?,?,?) ";

		Long id = new Random(50).nextLong();
		int update = jdbcTemplate.update(query,
				new Object[] { id, product.getPRODUCT_NAME(), product.getPRODUCT_PRICE(), product.getPRODUCT_DESC() });

		return update;
	}

	public List<ProductMapper> findAll() {

		List<ProductMapper> prodList = null;
		prodList = jdbcTemplate.query("SELECT * FROM PRODUCT",
				new BeanPropertyRowMapper<ProductMapper>(ProductMapper.class));

		System.out.println("---------------------" + prodList);
		return prodList;
	}

	public ProductMapper findByProductId(Long prodId) {

		ProductMapper product = jdbcTemplate.queryForObject("SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?",
				new Object[] { prodId }, new BeanPropertyRowMapper<ProductMapper>(ProductMapper.class));
		return product;
	}

	public List<ProductMapper> findAllByProductName(String prodName) {

		List<ProductMapper> prodList = jdbcTemplate.query("SELECT * FROM PRODUCT WHERE PRODUCT_NAME = ?",
				new String[] { prodName }, new BeanPropertyRowMapper<ProductMapper>(ProductMapper.class));

		return prodList;
	}

	@Transactional
	public int deleteByProductId(long prodId) {
		int update = jdbcTemplate.update("DELETE FROM PRODUCT WHERE PRODUCT_ID = ?", prodId);
		return update;
	}

	public int update(ProductMapper product) {

		String query = "UPDATE PRODUCT SET PRODUCT_NAME = ? ,PRODUCT_PRICE =? ,PRODUCT_DESC =? WHERE PRODUCT_ID = ? ";

		int update = jdbcTemplate.update(query, new Object[] { product.getPRODUCT_NAME(), product.getPRODUCT_PRICE(),
				product.getPRODUCT_DESC(), product.getPRODUCT_ID() });

		return update;
	}

}
