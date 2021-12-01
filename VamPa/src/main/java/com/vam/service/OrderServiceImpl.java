package com.vam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.OrderMapper;
import com.vam.model.OrderDTO;
import com.vam.model.OrderRequestDTO;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderDTO> getGoodsInfo(List<OrderRequestDTO> orders) {
		
		List<OrderDTO> result = new ArrayList<OrderDTO>();
		
		for(OrderRequestDTO ord : orders) {
			OrderDTO goodsInfo = orderMapper.getGoodsInfo(ord.getBookId());
			goodsInfo.setBookCount(ord.getBookCount());
			goodsInfo.initSaleTotal();
			result.add(goodsInfo);
		}
		
		return result;
	}
	
	

}
