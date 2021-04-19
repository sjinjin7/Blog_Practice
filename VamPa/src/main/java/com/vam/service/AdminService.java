package com.vam.service;

import java.util.List;

import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

public interface AdminService {

	/* 상품 등록 */
	public void bookEnroll(BookVO book);

	/* 카테고리 리스트 */
	public List<CateVO> cateList();
	
	/* 상품 리스트 */
	public List<BookVO> goodsGetList(Criteria cri);
	
	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);
	
	/* 상품 상세 정보 */
	public BookVO goodsGetDetail(int bookId);
	
}
