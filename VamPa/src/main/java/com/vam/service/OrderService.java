package com.vam.service;

import java.util.List;

import com.vam.model.OrderDTO;
import com.vam.model.OrderRequestDTO;
import com.vam.model.OrderRequestWrapper;

public interface OrderService {
	
	public List<OrderDTO> getGoodsInfo(List<OrderRequestDTO> orders);
	
	/* 주문 */
	public void  order(OrderRequestWrapper orw);
	
}
