package com.restaurant.menu;

import java.util.ArrayList;

import com.restaurant.items.Item;

public class Menu {

	private ArrayList<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void displayItems() {
		System.out.println("MENU:");
		for (Item item : items) {
			System.out.printf("%-30s price: %.2f BGN,  Served in: %-10s\n", item.getName(), item.getCost(),
					item.getContainer());
		}
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

}
