package com.engine.rules;

import com.engine.model.Order;
import com.engine.model.Promotion;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICalPrice.
 */
public interface ICalPrice {
	
	/**
	 * Calculate price.
	 *
	 * @param order the order
	 * @param promo the promo
	 * @return the double
	 */
	double calculatePrice(Order order, Promotion promo);
	
	/**
	 * Gets the a count.
	 *
	 * @param order the order
	 * @return the a count
	 */
	default  long getACount(Order order) {
		return order.getProducts().stream().filter((product) -> product.getpId().equals("A")).count();
	}
	
	/**
	 * Gets the b count.
	 *
	 * @param order the order
	 * @return the b count
	 */
	default long getBCount(Order order) {
		return order.getProducts().stream().filter((product) -> product.getpId().equals("B")).count();
	}
	
	/**
	 * Gets the c count.
	 *
	 * @param order the order
	 * @return the c count
	 */
	default long getCCount(Order order) {
		return order.getProducts().stream().filter((product) -> product.getpId().equals("C")).count();
	}
	
	/**
	 * Gets the d count.
	 *
	 * @param order the order
	 * @return the d count
	 */
	default long getDCount(Order order) {
		return order.getProducts().stream().filter((product) -> product.getpId().equals("D")).count();
	}
}
