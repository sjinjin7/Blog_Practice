package com.vam.model;

public class UpdateReplyDTO {

	private int bookId;
	
	private int ratingAvg;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(int ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	@Override
	public String toString() {
		return "UpdateReplyDTO [bookId=" + bookId + ", ratingAvg=" + ratingAvg + "]";
	}	
	
}
