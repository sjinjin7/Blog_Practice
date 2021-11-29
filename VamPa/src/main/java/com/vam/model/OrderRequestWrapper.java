package com.vam.model;

import java.util.List;

public class OrderRequestWrapper {

	private List<OrderRequestDTO> orders;

	public List<OrderRequestDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderRequestDTO> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderRequestWrapper [orders=" + orders + "]";
	}
	
}
