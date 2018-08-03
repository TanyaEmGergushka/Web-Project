package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;


public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private LocalDateTime datetime;
	private User user;
	private HashSet<String> basket;
	// private String adressSend = "abv";
//	private String adressDelivery;

	// ������ �� ������� ����� �������� ��� ���� ������� �������� � ���� �������
	// ����� � ������
	public Order(LocalDateTime datetime, User user, HashSet<String> basket) {
		this.datetime = datetime;
		setUsername(user);
		this.basket = basket;
	//	this.adressDelivery = adressDelivery;
	}

	public Order(long id, LocalDateTime datetime, User user, HashSet<String> basket/*, String adressDelivery*/) {
		this(datetime, user, basket /*,adressDelivery*/);
		setId(id);
	}

	public void setId(long id) {
		this.id = id;
	}

	protected long getOrderNumber() {
		return id;
	}

	public HashSet<String> getBasket() {
		return basket;
	}

	public User getUser() {
		return user;
	}
	
	public LocalDateTime getDatetime() {
		return datetime;
	}

	private void setUsername(User user) {
		if (user != null) {
			this.user = user;
		}
	}

}
