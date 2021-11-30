package com.vam.service;

import java.util.List;

import com.vam.model.OrderDTO;
import com.vam.model.OrderRequestDTO;

public interface OrderService {
	
	public List<OrderDTO> getGoodsInfo(List<OrderRequestDTO> orders);
	
}
