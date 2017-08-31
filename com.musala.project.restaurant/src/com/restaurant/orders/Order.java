package com.restaurant.orders;

import com.restaurant.items.Item;

public class Order {

	private Item item;
	private int quantity;

	public Order(Item item, int quantity) {

		if (item != null) {
			this.item = item;
		} else {
			throw new IllegalArgumentException("Item cannot be null");
		}

		if (quantity != 0) {
			this.quantity = quantity;
		} else {
			throw new IllegalArgumentException("Quantity cannot be 0");
		}
	}

	public String getName() {
		return item.getName();
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

}
