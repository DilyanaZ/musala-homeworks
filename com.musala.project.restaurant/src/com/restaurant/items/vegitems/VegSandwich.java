package com.restaurant.items.vegitems;

import com.restaurant.items.Sandwich;
import com.restaurant.items.container.Container;

public class VegSandwich extends Sandwich {

	public VegSandwich(String name, double cost) {
		super(name, cost);
	}

	@Override
	public Container getContainer() {
		return Container.RECYCLED_PAPER;
	}

}
