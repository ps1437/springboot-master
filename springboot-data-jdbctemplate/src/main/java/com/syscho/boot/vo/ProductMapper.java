package com.syscho.boot.vo;

import java.io.Serializable;

/**
 * @author Soni
 *
 */
public class ProductMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7609287080733854040L;
	private Long PRODUCT_ID;
	private String PRODUCT_NAME;
	private int PRODUCT_PRICE;
	private String PRODUCT_DESC;

	public Long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(Long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public int getPRODUCT_PRICE() {
		return PRODUCT_PRICE;
	}

	public void setPRODUCT_PRICE(int pRODUCT_PRICE) {
		PRODUCT_PRICE = pRODUCT_PRICE;
	}

	public String getPRODUCT_DESC() {
		return PRODUCT_DESC;
	}

	public void setPRODUCT_DESC(String pRODUCT_DESC) {
		PRODUCT_DESC = pRODUCT_DESC;
	}

}
