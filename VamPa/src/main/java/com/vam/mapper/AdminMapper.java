package com.vam.mapper;

import java.util.List;

import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

public interface AdminMapper {

	/* 상품 등록 */
	public void bookEnroll(BookVO book);
	
	/* 카테고리 리스트 */
	public List<CateVO> cateList();
	
	/* 상품 리스트 */
	public List<BookVO> goodsGetList(Criteria cri);
	
	/* 검색 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);
	
	/* 상품 상세 페이지 */
	public BookVO goodsGetDetail(int bookId);
	
	/* 상품 수정 */
	public int goodsModify(BookVO vo);	
	
	/* 상품 정보 삭제 */
	public int goodsDelete(int bookId);
	
	/* 이미지 등록 */
	public int imageEnroll(AttachImageVO vo);
	
	/* 이미지 전체 삭제 */
	public void deleteImageAll(int bookId);
	
	/* 배치 삭제 이미지 리스트 */ 
	public List<AttachImageVO> getOldFiles();
	
}
