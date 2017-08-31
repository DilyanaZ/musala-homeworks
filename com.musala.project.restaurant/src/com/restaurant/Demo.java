package com.restaurant;

import com.restaurant.items.Coffee;
import com.restaurant.items.Juices;
import com.restaurant.items.Tea;
import com.restaurant.items.nonvegitems.MeatDish;
import com.restaurant.items.nonvegitems.NonVegSandwich;
import com.restaurant.items.vegitems.VegSandwich;
import com.restaurant.items.vegitems.VeganSalat;
import com.restaurant.menu.Menu;
import com.restaurant.orders.PayBill;
import com.restaurant.orders.PlaceOrder;

public class Demo {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.addItem(new VegSandwich("Vegan Shit", 5.4d));
		menu.addItem(new NonVegSandwich("Cheese Burger", 3.4d));
		menu.addItem(new Coffee("Espresso", 2.2d));
		menu.addItem(new Tea("Green Tea", 1.6d));
		menu.addItem(new Juices("Orange Juice", 5.3d));
		menu.addItem(new VeganSalat("Vegan Salat With Kinoa", 8.4d));
		menu.addItem(new MeatDish("Steak With Fries", 6.4d));
		menu.addItem(new Coffee("Cappuccino", 3.4d));
		menu.addItem(new Tea("Mint Tea", 1.4d));

		menu.displayItems();
		System.out.println();

		PlaceOrder order = new PlaceOrder(menu);
		order.orderItem("Green Tea", 2);
		order.orderItem("Vegan Salat With Kinoa", 1);

		order.orderItem("Sushi", 1);
		order.orderItem("Shopska Salat", 1);

		order.orderItem("Steak With Fries", 1);
		order.orderItem("Cheese Burger", 1);
		System.out.println();
		// Eat, eat, drink, drink

		PayBill bill = new PayBill();
		double ammount = bill.payableAmount(order);

		System.out.printf("Now pay: %.2f BGN\n", ammount);
	}
}
