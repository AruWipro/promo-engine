package com.engine.service;

import java.util.ArrayList;
import java.util.List;

import com.engine.model.Promotion;

/**
 * The Class PromoListManager.
 */
public class PromoListManager {
	
	/** The promotions list. */
	List<Promotion> promotionsList;

	/**
	 * Adds the promotion.
	 *
	 * @param promotion the promotion
	 */
	public void addPromotion(Promotion promotion) {
		if (this.promotionsList.isEmpty()) {
			this.promotionsList = new ArrayList<Promotion>();
		}
		this.promotionsList.add(promotion);
	}
	
	
	/**
	 * Removes the promotion.
	 *
	 * @param promotion the promotion
	 */
	public void removePromotion(Promotion promotion) {
		this.promotionsList.remove(promotion);
	}


	/**
	 * Gets the promotions list.
	 *
	 * @return the promotions list
	 */
	public List<Promotion> getPromotionsList() {
		return promotionsList;
	}


	/**
	 * Sets the promotions list.
	 *
	 * @param promotionsList the new promotions list
	 */
	public void setPromotionsList(List<Promotion> promotionsList) {
		this.promotionsList = promotionsList;
	}
}
