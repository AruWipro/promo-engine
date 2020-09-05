package com.engine.service;

import com.engine.model.Order;
import com.engine.model.Product;
import com.engine.model.Promotion;
import com.engine.rules.ICalPrice;

/**
 * The Enum PromotionCalculator.
 */
public enum PromotionCalculator implements ICalPrice {

	PROMO_3A {
		@Override
		public double calculatePrice(Order order, Promotion promo) {
			long aCount = getACount(order);
			double aPrice  = 0;
			Integer minSKUQuanity = promo.getDiscountSKU().get("A") != null ? promo.getDiscountSKU().get("A") : null;
			if(minSKUQuanity != null && (aCount % minSKUQuanity == 0)) {
				aPrice = (aCount/minSKUQuanity)*promo.getPromoPrice();
			}else if (aCount < minSKUQuanity) {
				aPrice = aCount*Product.getPriceById("A");
				
			}else {
				aPrice =  ((aCount / 3) * promo.getPromoPrice() + (aCount % 3) * Product.getPriceById("A"));
			}
			return aPrice+getBCount(order)*Product.getPriceById("B")+
					getCCount(order)*Product.getPriceById("C")+
					getDCount(order)*Product.getPriceById("D");
		}

		
	},

	PROMO_2B {
		
		/**
		 * Calculate price.
		 *
		 * @param order the order
		 * @param promo the promo
		 * @return the double
		 */
		@Override
		public double calculatePrice(Order order, Promotion promo) {
			long bCount = getBCount(order);
			double bPrice = 0;
			Integer minSKUQuantity = promo.getDiscountSKU().get("B") != null ? promo.getDiscountSKU().get("B") : null;
			if(minSKUQuantity != null && bCount % minSKUQuantity == 0) {
				bPrice = (bCount / minSKUQuantity) * promo.getPromoPrice();
			} else if( bCount < minSKUQuantity) {
				bPrice = bCount * Product.getPriceById("B");
			}
			else {
				bPrice =  ((bCount / 2) * promo.getPromoPrice() + (bCount % 3) * Product.getPriceById("B"));
			}
			return  getACount(order)*Product.getPriceById("A") + 
					bPrice + getCCount(order)*Product.getPriceById("C") +
					getDCount(order)*Product.getPriceById("D");
		}
	},

	PROMO_CD {
		@Override
		public double calculatePrice(Order order, Promotion promo) {
			long cCount = getCCount(order);
			long dCount = getDCount(order);
			double cPrice = 0;
			if(cCount != 0 && cCount < dCount) {
				cPrice = ((cCount * promo.getPromoPrice())+dCount * Product.getPriceById("D"));
			}else if(cCount == dCount) {
				cPrice = cCount * promo.getPromoPrice();
			}
			else {
				cPrice = ((dCount * promo.getPromoPrice()) + cCount * Product.getPriceById("C"));
			}
			return getACount(order)*Product.getPriceById("A") +
				   getBCount(order)*Product.getPriceById("B") +
				   cPrice;
		}

	};
	


}
