package model;

import java.io.Serializable;
import java.util.HashMap;

public class Basket implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private HashMap<Product, Integer> products = new HashMap<>();

	protected void addProductsInBasket(Product product, Integer quantity) {
		if (this.products.containsKey(product)) {
			this.products.put(product, this.products.get(product) + quantity);
		} else {
			this.products.put(product, quantity);
		}
	}

	@Override
	public String toString() {
		return "Basket: " + products.entrySet() + ";";
	}

	public HashMap<Product, Integer> getProducts() {
		return products;
	}

	
}
