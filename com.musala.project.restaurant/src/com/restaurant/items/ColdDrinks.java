package com.restaurant.items;

public abstract class ColdDrinks implements Item {

	private String name;
	private double cost;
	private int quantity;

	private Category category = Category.DRINKS;

	public ColdDrinks(String name, double cost) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}

		this.name = name;
		this.cost = cost;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public Category getCategory() {
		return category;
	}

}
