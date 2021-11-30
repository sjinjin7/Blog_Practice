package com.vam.mapper;

import com.vam.model.OrderDTO;

public interface OrderMapper {
	
	/* 주문 상품 정보 */	
	public OrderDTO getGoodsInfo(int bookId);
	


}
