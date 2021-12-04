package com.vam.model;

import java.util.Date;
import java.util.List;

public class OrderRequestWrapper {

	private List<OrderRequestDTO> orders;
	
	//주문번호
	private String orderId;
	
	//받는이
	private String addressee;
	
	//회원 아이디
	private String memberId;
	
	//회원 우편번호
	private String memberAddr1;
	
	//회원 주소
	private String memberAddr2;
	
	//회원 상세주소
	private String memberAddr3;
	
	//주문 상태
	private String orderState;
	
	//배송비
	private int deliveryCost;
	
	//사용 포인트
	private int usePoint;
	
	//주문 날짜
	private Date orderDate;
	
	//table x
	//판매가(모든 상품 비용)
	private int orderSalePrice;
	
	//적립 포인트
	private int orderSavePoint;
	
	/* 최종 판매 비용 */
	private int orderFinalSalePrice;
	



	public List<OrderRequestDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderRequestDTO> orders) {
		this.orders = orders;
	}
	

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberAddr1() {
		return memberAddr1;
	}

	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}

	public String getMemberAddr2() {
		return memberAddr2;
	}

	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}

	public String getMemberAddr3() {
		return memberAddr3;
	}

	public void setMemberAddr3(String memberAddr3) {
		this.memberAddr3 = memberAddr3;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderSalePrice() {
		return orderSalePrice;
	}

	public int getOrderSavePoint() {
		return orderSavePoint;
	}

	public int getOrderFinalSalePrice() {
		return orderFinalSalePrice;
	}

	/* 배송비 초기화 */
	public void getOrderPriceInfo() {
		/* 상품 비용 & 적립포인트 */
			for(OrderRequestDTO order : orders) {
				orderSalePrice += order.getTotalPrice();
				orderSavePoint += order.getTotalSavePoint();
			}
		/* 배송비용 */
			if(orderSalePrice >= 30000) {
				deliveryCost = 0;
			} else {
				deliveryCost = 3000;
			}
		/* 최종 비용(상품 비용 + 배송비 - 사용 포인트) */
			orderFinalSalePrice = orderSalePrice + deliveryCost - usePoint;
	}

	@Override
	public String toString() {
		return "OrderRequestWrapper [orders=" + orders + ", orderId=" + orderId + ", addressee=" + addressee
				+ ", memberId=" + memberId + ", memberAddr1=" + memberAddr1 + ", memberAddr2=" + memberAddr2
				+ ", memberAddr3=" + memberAddr3 + ", orderState=" + orderState + ", deliveryCost=" + deliveryCost
				+ ", usePoint=" + usePoint + ", orderDate=" + orderDate + ", orderSalePrice=" + orderSalePrice
				+ ", orderSavePoint=" + orderSavePoint + ", orderFinalSalePrice=" + orderFinalSalePrice + "]";
	}



}
