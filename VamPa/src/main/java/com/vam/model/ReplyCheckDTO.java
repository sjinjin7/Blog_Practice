package com.vam.model;

public class ReplyCheckDTO {

	private String memberId;
	
	private int bookId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "ReplyCheckDTO [memberId=" + memberId + ", bookId=" + bookId + "]";
	}
	
}
