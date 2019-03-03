package com.syscho.boot.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Soni
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long productId;
	private String productName;
	private int productPrice;
	private String productDescription;

	public Product(String productName, int productPrice, String productDescription) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}

	public Product() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
