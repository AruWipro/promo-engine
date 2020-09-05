package com.engine.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.engine.model.Order;
import com.engine.model.Product;
import com.engine.model.Promotion;
import com.engine.service.PromoListManager;
import com.engine.service.PromotionCalculator;

public class PlaceOrder {
	public static void main(String[] args) {
		// Initialize Promos
		Map<String, Integer> promo1 = new HashMap<String, Integer>();
		promo1.put("A", 3);

		Map<String, Integer> promo2 = new HashMap<String, Integer>();
		promo2.put("B", 2);

		Map<String, Integer> promo3 = new HashMap<String, Integer>();
		promo3.put("C", 1);
		promo3.put("D", 1);

		// Add the promos to a list manager
		PromoListManager list = new PromoListManager();
		list.addPromotion(new Promotion(1, "PROMO_3A", promo1, 130));
		list.addPromotion(new Promotion(2, "PROMO_2B", promo2, 45));
		list.addPromotion(new Promotion(3, "PROMO_CD", promo3, 30));

		// Construct Orders
		Order order1 = new Order(1, new ArrayList<Product>(Arrays.asList(new Product("A"), new Product("A"),
				new Product("B"), new Product("B"), new Product("C"), new Product("D"))));
		Order order2 = new Order(2, new ArrayList<Product>(Arrays.asList(new Product("A"), new Product("A"),
				new Product("A"), new Product("A"), new Product("A"), new Product("A"), new Product("B"))));
		Order order3 = new Order(3, new ArrayList<Product>(Arrays.asList(new Product("A"), new Product("A"),
				new Product("D"), new Product("B"), new Product("B"))));

		List<Order> ordersList = new ArrayList<Order>(Arrays.asList(order1, order2, order3));

		// Calculating the price after choosing the best promo
		ordersList.forEach(order -> {

			Double maxDiscount = list.getPromotionsList().stream().map(promo -> PlaceOrder.getBestPrice(order, promo))
					.min(Double::compare).get();
			System.out.println(
					"Max Dis after applying single best promo code to " + order.getOrderId() + " is " + maxDiscount);

		});

	}

	/**
	 * @param order2
	 * @param promo
	 * @return
	 */
	private static Double getBestPrice(Order order2, Promotion promo) {
		String name = promo.getPromoName();
		Double price = PromotionCalculator.valueOf(name).calculatePrice(order2, promo);

		return price;
	}
}
