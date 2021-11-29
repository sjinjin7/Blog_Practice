package com.vam.model;

public class OrderRequestDTO {

    private int bookId;
    
    private int bookCount;

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

	@Override
	public String toString() {
		return "OrderRequestDTO [bookId=" + bookId + ", bookCount=" + bookCount + "]";
	}
    
    
	
}
