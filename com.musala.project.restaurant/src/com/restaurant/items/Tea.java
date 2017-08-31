package com.restaurant.items;

import com.restaurant.items.container.Container;

public class Tea extends HotDrinks{

	public Tea(String name, double cost) {
		super(name, cost);
	}
	
	
	@Override
	public Container getContainer() {
		return Container.PLASTIC_CUP;
	}

}
