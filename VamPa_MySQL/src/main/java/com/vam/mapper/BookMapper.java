package com.vam.mapper;

import java.util.List;

import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.Criteria;

public interface BookMapper {

	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int bookId);
	
	/* 상품 검색 */
	public List<BookVO> getGoodsList(Criteria cri);
	
	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);	
	
	/* 작가 id 리스트 요청 */
	public String[] getAuthorIdList(String keyword);
	
}
