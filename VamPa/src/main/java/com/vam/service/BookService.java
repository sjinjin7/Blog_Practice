package com.vam.service;

import java.util.List;

import com.vam.model.AttachImageVO;

public interface BookService {

		// 본편의 경우 AttachServce로 변경해줌
	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int bookId);

}
