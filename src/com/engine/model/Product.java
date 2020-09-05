package com.engine.model;

/**
 * The Class Product.
 *
 * @author apiratla
 */
public class Product {
	
	/** The p id. */
	public String pId;
	
	/** The price. */
	public double price;

	/**
	 * Instantiates a new product.
	 *
	 * @param id the id
	 */
	public Product(String id) {
		this.pId = id;
		this.price = getPriceById(id);

	}

	/**
	 * Gets the p id.
	 *
	 * @return the p id
	 */
	public String getpId() {
		return pId;
	}

	/**
	 * Sets the p id.
	 *
	 * @param pId the new p id
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the price by id.
	 *
	 * @param pId the id
	 * @return the price by id
	 */
	public static double getPriceById(String pId) {
		double price = 0;
		switch (pId) {
		case "A":
			price = 50;
			break;

		case "B":
			price = 30;
			break;

		case "C":
			price = 20;
			break;

		case "D":
			price = 15;
			break;

		}
		return price;
	}

}
