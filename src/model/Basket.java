package model;

import java.io.Serializable;
import java.util.HashMap;

public class Basket implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private HashMap<Product, Integer> orders = new HashMap<>();

	protected void addProductsInBasket(Product product, Integer quantity) {
		if (this.orders.containsKey(product)) {
			this.orders.put(product, this.orders.get(product) + quantity);
		} else {
			this.orders.put(product, quantity);
		}
	}

	@Override
	public String toString() {
		return "Basket: " + orders.entrySet() + ";";
	}

}
