package com.vam.mapper;

import com.vam.model.BookVO;
import com.vam.model.MemberVO;
import com.vam.model.OrderDTO;
import com.vam.model.OrderRequestDTO;
import com.vam.model.OrderRequestWrapper;

public interface OrderMapper {

	/* 주문 상품 정보 */	
	public OrderDTO getGoodsInfo(int bookId);
	
	/* 주문 상품 정보 */	
	public OrderRequestDTO getOrderInfo(int bookId);
	
	/* 주문 테이블 등록 */
	public int enrollOrder(OrderRequestWrapper orw);
	
	/* 주문 아이템 테이블 등록 */
	public int enrollOrderItem(OrderRequestDTO orw);
	
	/* 주문 금액 차감 */
	public int deductMoney(MemberVO member);
	
	/* 주문 재고 차감 */
	public int deductStock(BookVO book);	
	
}
