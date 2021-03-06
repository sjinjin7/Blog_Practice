package com.vam.model;

public class AttachImageVO {
	
	/* 파일 이름 */
	public String fileName;
	
	/* 경로 */
	public String uploadPath;
	
	/* uuid */
	public String uuid;
	
	/* id */
	public int bookId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "AttachImageVO [fileName=" + fileName + ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", bookId="
				+ bookId + "]";
	}


	
}
