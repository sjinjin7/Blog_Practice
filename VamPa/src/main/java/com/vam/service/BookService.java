package com.vam.service;

import java.util.List;

import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CateFilterDTO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

public interface BookService {

		// 본편의 경우 AttachServce로 변경해줌
	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int bookId);
	
	/* 상품 검색 */
	public List<BookVO> getGoodsList(Criteria cri);
	
	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);	
	
	/* 국내 카테고리 리스트 */
	public List<CateVO> getCateCode1();
	
	/* 외국 카테고리 리스트 */
	public List<CateVO> getCateCode2();	
	
	/* 검색결과 카테고리 필터 정보 */
	public List<CateFilterDTO> getCateInfoList(Criteria cri);	

}
