package model;

import java.io.Serializable;

public class Product implements Serializable {

	// TODO create id for every product and add quantity in stock
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String description;
	private double price;
	private String quantity;

	public Product(String name, String description, double price, String quantity) {
		setName(name);
		setDescription(description);
		setPrice(price);
		setQuantity(quantity);
		}

	public Product(long id, String name, String description, double price, String quantity) {
		this(name, description, price, quantity);
		setId(id);
	}
	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getQuantity() {
		return quantity;
	}

	

	@Override
	public String toString() {
		return id + "," + name + ", " + description + "," + price
				+ "," + quantity ;
	}

	public String getName() {
		return name;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	private void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
	}

	private void setDescription(String description) {
		if (description != null && !description.isEmpty()) {
			this.description = description;
		}
	}

	private void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}

	private void setQuantity(String quantity) {
		if (quantity != null) {
			this.quantity = quantity;
		}
	}

}
