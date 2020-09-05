package com.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.engine.model.Order;
import com.engine.model.Product;
import com.engine.model.Promotion;
import com.engine.service.PromoListManager;
import com.engine.service.PromotionCalculator;

public class PromotionTest {

	
	public static PromoListManager promosList() {
		PromoListManager manager = new PromoListManager();
		List<Promotion> list = Arrays.asList(mockPromotions());
		manager.setPromotionsList(list);
		return manager;
	}


	public static Promotion[]mockPromotions() {

		Map<String, Integer> promo1 = new HashMap<String, Integer>();
		promo1.put("A", 2);

		Map<String, Integer> promo2 = new HashMap<String, Integer>();
		promo2.put("B", 2);

		Map<String, Integer> promo3 = new HashMap<String, Integer>();
		promo3.put("C", 1);
		List<Promotion> list = new ArrayList<Promotion>();
		
		return new Promotion[] {new Promotion(1, "PROMO_3A", promo1, 80),
				new Promotion(2, "PROMO_2B", promo2, 45),
				new Promotion(3, "PROMO_CD", promo2, 30)
		};

	}
	
	

	public static Order mockOrders() {

		Order order = new Order(2, new ArrayList<Product>(Arrays.asList(
				new Product("A"), new Product("A"),
				new Product("A"), new Product("A"),
				new Product("A"), new Product("A"), 
				new Product("B"))));
		return order;

	}
	
	@Test
    public void testMaxDiscount() {
		Order order = mockOrders();
		Double asserAmount = 270d;
		System.out.println("Order is"+order);
		 Double maxDiscount = promosList().getPromotionsList().stream()
			.map(promo -> PromotionTest.getBestPrice(order, promo))
			.min(Double::compare).get();
		 assertEquals("Max Discount is",asserAmount,maxDiscount);
    }
	
	private static Double getBestPrice(Order order2, Promotion promo) {
		String name = promo.getPromoName();
		Double price = PromotionCalculator.valueOf(name).calculatePrice(order2, promo);

		return price;
	}

}
