# Approach Taken

The idea is to apply all the promotions independently and return the order total with the highest discount.

> Only one promo can be applied for an order. Can be extended for a combination also.

# Model Classes

 - The major model classes in this project are 
	 - Product
	 - Order
	 - Promotion
- The price of the product is auto assigned by it's type
- Promo Can be added or deleted via **PromoListManager**

## PromotionCalculation

 - Iterate the list of Promotions available and pass in each order to the promos available.
 - Tried Enums to implement promo fulfilment
 -  Can also be done by simple inheritance  

