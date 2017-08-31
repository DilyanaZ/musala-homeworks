package com.restaurant.orders;

public class PayBill {

	public double payableAmount(PlaceOrder order) {
		double ammount = 0d;
		for (Order ordered : order.getOrder()) {
			ammount += ordered.getItem().getCost();
		}

		return ammount;
	}

}
