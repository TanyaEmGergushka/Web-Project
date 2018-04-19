package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
public class MakeOrder {
 //спрямо видеото но не работи - лекция 28
	
	public Order makeOrder (){
	ObjectInputStream sendOrders = null;
		Order ord = null;
		try {
			sendOrders = new ObjectInputStream(new FileInputStream(new File("omg.txt")));
			ord = (Order) sendOrders.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("not found file ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("oi mistake");
		} catch (ClassNotFoundException e) {
		System.out.println("not found class");
		}
		finally {
			try {
				if (sendOrders != null){
					sendOrders.close();
				}
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return ord;
		
	}
}
