package com.vam.mapper;

import java.util.List;

import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

public interface AdminMapper {

	/* 상품 등록 */
	public void bookEnroll(BookVO book);
	
	/* 카테고리 리스트 */
	public List<CateVO> cateList();
	
	/* 상품 리스트 */
	public List<BookVO> bookList(Criteria cri);
	
	/* 검색 상품 총 갯수 */
	public int bookGetTotal(Criteria cri);
	
}
