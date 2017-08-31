package com.restaurant.orders;

import java.util.ArrayList;
import java.util.List;

import com.restaurant.items.Item;
import com.restaurant.menu.Menu;

public class PlaceOrder {

	private List<Order> orders = new ArrayList<>();
	private List<Item> availableItems = new ArrayList<>();

	public PlaceOrder(Menu menu) {
		availableItems = menu.getItems();
	}

	public void orderItem(String item, int quantity) {
		boolean itemAvailable = false;
		for (Item itemInMenu : availableItems) {
			if (itemInMenu.getName().equals(item)) {
				Order order = new Order(itemInMenu, quantity);
				orders.add(order);
				itemAvailable = true;
				break;
			}
		}
		if (!itemAvailable) {
			System.out.println("Item \"" + item + "\" is not available in the menu.");
		}
	}

	public List<Order> getOrder() {
		return orders;
	}
}
