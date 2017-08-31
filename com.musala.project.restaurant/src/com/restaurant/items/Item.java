package com.restaurant.items;

import com.restaurant.items.container.Container;

public interface Item {
	
	public int getQuantity() ;
	public void setQuantity(int quantity);
	public String getName();
	public Category getCategory();
	public double getCost();
	public Container getContainer();
	
}
