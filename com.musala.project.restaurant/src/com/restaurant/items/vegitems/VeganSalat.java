package com.restaurant.items.vegitems;

import com.restaurant.items.MainCources;
import com.restaurant.items.container.Container;

public class VeganSalat extends MainCources {

	public VeganSalat(String name, double cost) {
		super(name, cost);
	}

	@Override
	public Container getContainer() {
		return Container.PLASTIC_PLATE;
	}

}
