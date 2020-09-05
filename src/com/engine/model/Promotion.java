package com.engine.model;

import java.util.Map;

/**
 * The Class Promotions.
 */
public class Promotion {
	
	/** The promo id. */
	private int promoId;
	
	/** The discount SKU. */
	private Map<String,Integer> discountSKU;
	
	/** The promo price. */
	private double promoPrice;
	
	
	private String promoName;
	
	
	
	
	public Promotion(int promoId, String promoNAme, Map<String, Integer> discountSKU, double promoPrice) {
		super();
		this.promoId = promoId;
		this.promoName = promoNAme;
		this.discountSKU = discountSKU;
		this.promoPrice = promoPrice;
	}

	/**
	 * Gets the promo id.
	 *
	 * @return the promo id
	 */
	public int getPromoId() {
		return promoId;
	}
	
	/**
	 * Sets the promo id.
	 *
	 * @param promoId the new promo id
	 */
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	
	/**
	 * Gets the discount SKU.
	 *
	 * @return the discount SKU
	 */
	public Map<String, Integer> getDiscountSKU() {
		return discountSKU;
	}
	
	/**
	 * Sets the discount SKU.
	 *
	 * @param discountSKU the discount SKU
	 */
	public void setDiscountSKU(Map<String, Integer> discountSKU) {
		this.discountSKU = discountSKU;
	}
	
	/**
	 * Gets the promo price.
	 *
	 * @return the promo price
	 */
	public double getPromoPrice() {
		return promoPrice;
	}
	
	/**
	 * Sets the promo price.
	 *
	 * @param promoPrice the new promo price
	 */
	public void setPromoPrice(double promoPrice) {
		this.promoPrice = promoPrice;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	
}
