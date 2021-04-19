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
	
	/* 상품 총 개수 */
	public int bookGetTotal(Criteria cri);
	
	/* 상품 상세 페이지 */
	public BookVO goodsGetDetail(int bookId);
	
}
