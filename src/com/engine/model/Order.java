package com.engine.model;

import java.util.List;

/**
 * The Class Order.
 *
 * @author apiratla
 */
public class Order {
	
	/**
	 * Instantiates a new order.
	 *
	 * @param id the orderId
	 * @param products the products
	 */
	public Order(int id,List<Product> products) {
		this.orderId = id;
		this.products = products;
		
	}
	
	/** The order id. */
	private int orderId;
	
	/** The products. */
	private List<Product> products;

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 *
	 * @param products the new products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
}
