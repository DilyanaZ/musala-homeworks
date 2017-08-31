package com.restaurant.items.nonvegitems;

import com.restaurant.items.Sandwich;
import com.restaurant.items.container.Container;

public class NonVegSandwich extends Sandwich {

	public NonVegSandwich(String name, double cost) {
		super(name, cost);
	}

	@Override
	public Container getContainer() {
		return Container.PAPER;
	}

}
