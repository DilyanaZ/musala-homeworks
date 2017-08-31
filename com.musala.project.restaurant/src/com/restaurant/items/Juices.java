package com.restaurant.items;

import com.restaurant.items.container.Container;

public class Juices extends ColdDrinks {

	public Juices(String name, double cost) {
		super(name, cost);
	}

	@Override
	public Container getContainer() {
		return Container.BOTTLE;
	}

}
