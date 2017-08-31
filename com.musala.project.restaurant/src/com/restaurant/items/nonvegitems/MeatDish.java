package com.restaurant.items.nonvegitems;

import com.restaurant.items.MainCources;
import com.restaurant.items.container.Container;

public class MeatDish extends MainCources {

	public MeatDish(String name, double cost) {
		super(name, cost);
	}

	@Override
	public Container getContainer() {
		return Container.PAPER_PLATE;
	}

}
