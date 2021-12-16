package com.vam.mapper;

import java.util.List;

import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;
import com.vam.model.OrderRequestWrapper;

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
	
	/* 지정 상품 이미지 정보 얻기 */
	public List<AttachImageVO> getAttachInfo(int bookId);	
	
	/* 주문 상품 리스트 */
	public List<OrderRequestWrapper> getOrderList(Criteria cri);
	
	/* 주문 총 갯수 */
	public int getOrderTotal(Criteria cri);
	
	/* 주문 취소 */
	public int orderCancle(String orderId);
	
}
