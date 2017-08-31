package com.restaurant.items;

public abstract class Sandwich implements Item {
	
	private Category category = Category.SNACKS;
	private String name;
	private double cost;
	private int quantity;

	
	public Sandwich(String name, double cost) {
	
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}

		this.name = name;
		this.cost = cost;
		
	}
	
	@Override
	public Category getCategory() {
		return category;
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
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public void setQuantity(int quantity) {
		if(quantity != 0) {
			this.quantity = quantity;
		}
	}
	
	

}
