package com.syscho.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Soni
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

	@Id
	@GeneratedValue
	private Long productId;
	private String productName;
	private int productPrice;
	private String productDescription;

	public ProductEntity(String productName, int productPrice, String productDescription) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}

}
