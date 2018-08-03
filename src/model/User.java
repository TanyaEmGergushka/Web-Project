package model;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//import com.google.gson.Gson;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String username;
	private String company;
	private String password;
	private String email;
	private HashSet<Order> orders;
	// private Basket basket = new Basket();


	// създаване на потребителя след регистрация
	public User(String name, String company, String password, String email) {
		// TODO do-while - if string is null and add adress
		setName(name);
		setCompany(company);
		setPassword(password);
		setEmail(email);
	}

	// за създаване на потребител от базата при успешен login. При регистрация
	// или успешен вход ще се създава такъв потребител
	public User(long id, String username,  String password, String company, String email) {
		this(username, company, password, email);
		setId(id);
	//	this.orders = orders;
	}

	
	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}

	public String getCompany() {
		return company;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	protected void setPassword(String password) {
		if (password != null && !password.isEmpty()) {
			this.password = password;
		} else {
			System.out.println("enter password");
		//	throw new InvalidUserParameters;
		}
	}

	protected void setEmail(String email) {
		if (email != null && !email.isEmpty()) {
			this.email = email;
		} else {
			System.out.println("enter email");
		}
	}

//	public void makeOrder() {
//		Order order = new Order(this);
//		System.out.println(this + " " + order.getOrderNumber());
//
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(order));
//		String gsonStr = gson.toJson(order);
//
//		File orderFile = new File("new Order" + order.getOrderNumber() + ".txt");
//		ObjectOutputStream orderSave = null;
//		try {
//
//			if (!orderFile.exists()) {
//				orderFile.createNewFile();
//				System.out.println("new order with number: " + order.getOrderNumber());
//				orderSave = new ObjectOutputStream(new FileOutputStream(orderFile));
//				orderSave.writeUTF(gsonStr);
//				orderSave.writeObject(gson.toJson(order));
//				System.out.println("you have a order");
//			} else {
//				System.out.println("i have same order");
//			}
//		} catch (Exception e) {
//			System.out.println("We have a problem with this order");
//			e.printStackTrace();
//		}
//
//		finally {
//			if (orderSave != null) {
//				try {
//					orderSave.close();
//				} catch (IOException e) {
//					System.out.println(e.getMessage());
//				}
//			}
//
//		}
//	}
//
	 public Set <Order> getOrders() {
		return  Collections.unmodifiableSet(orders);
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	// protected Basket getBasket() {
	// return basket;
	// }
	//
	// public void chooseProduct(Product product, Integer number) {
	// this.basket.addProductsInBasket(product, number);
	// }

	private void setName(String name) { // does not compile with thread!!!
		if (name != null && !name.isEmpty()) {
			this.username = name;
		}
	}

	private void setCompany(String company) {
		if (company != null && !company.isEmpty()) {
			this.company = company;
		}
	}

	@Override
	public String toString() {
		return "User [name=" + username + ", company=" + company + ", basket="
				+ /* basket + */ "]";
	}

	public String getUsername() {
		return username;
	}



}
