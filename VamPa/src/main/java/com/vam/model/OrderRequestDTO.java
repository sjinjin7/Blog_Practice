package com.vam.model;

public class OrderRequestDTO {

    private int bookId;
    
    private int bookCount;
    
    private int orderItemId;
    
    private String orderId;
    
    private int bookPrice;
    
    private double bookDiscount;
    
    private int savePoint;
    
    // tabe x
    private int salePrice;
    
    private int totalPrice;
    
    private int totalSavePoint;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookDiscount() {
		return bookDiscount;
	}

	public void setBookDiscount(double bookDiscount) {
		this.bookDiscount = bookDiscount;
	}

	public int getSavePoint() {
		return savePoint;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public int getTotalSavePoint() {
		return totalSavePoint;
	}
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1-this.bookDiscount));
		this.totalPrice = this.salePrice*this.bookCount;
		this.savePoint = (int)(Math.floor(this.salePrice*0.05));
		this.totalSavePoint =this.savePoint * this.bookCount;
		
	}	

	@Override
	public String toString() {
		return "OrderRequestDTO [bookId=" + bookId + ", bookCount=" + bookCount + ", orderItemId=" + orderItemId
				+ ", orderId=" + orderId + ", bookPrice=" + bookPrice + ", bookDiscount=" + bookDiscount
				+ ", savePoint=" + savePoint + ", salePrice=" + salePrice + ", totalPrice=" + totalPrice
				+ ", totalSavePoint=" + totalSavePoint + "]";
	}    


    
    
	
}
