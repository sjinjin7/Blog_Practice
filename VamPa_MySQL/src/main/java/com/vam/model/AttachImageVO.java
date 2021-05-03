package com.vam.model;

public class AttachImageVO {
	
	/* 파일 이름 */
	public String fileName;
	
	/* 경로 */
	public String uploadPath;
	
	/* uuid */
	public String uuid;
	
	/* id */
	public int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AttachImageVO [fileName=" + fileName + ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", id=" + id
				+ "]";
	}
}
