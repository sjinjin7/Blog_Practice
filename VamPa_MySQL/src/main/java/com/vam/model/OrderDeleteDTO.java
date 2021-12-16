package com.vam.model;

public class OrderDeleteDTO {
	private String orderId;
	
	private String keyword;
	
	private int amount;
	
	private int pageNum;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "OrderDeleteDTO [orderId=" + orderId + ", keyword=" + keyword + ", amount=" + amount + ", pageNum="
				+ pageNum + "]";
	}
}
