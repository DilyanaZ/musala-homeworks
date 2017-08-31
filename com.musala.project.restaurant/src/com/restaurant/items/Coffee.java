package com.restaurant.items;

import com.restaurant.items.container.Container;

public class Coffee extends HotDrinks {

	public Coffee(String name, double cost) {
		super(name, cost);
	}
	
	@Override
	public Container getContainer() {
		return Container.PAPER_CUP;
	}

}
