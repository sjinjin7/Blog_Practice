package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.mapper.AdminMapper;
import com.vam.mapper.BookMapper;
import com.vam.mapper.MemberMapper;
import com.vam.mapper.OrderMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;
import com.vam.model.MemberVO;
import com.vam.model.OrderDeleteDTO;
import com.vam.model.OrderRequestDTO;
import com.vam.model.OrderRequestWrapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
	/* 상품 등록 */
	@Transactional
	@Override
	public void bookEnroll(BookVO book) {
		
		log.info("(srevice)bookEnroll........");
		
		adminMapper.bookEnroll(book);
		
		if(book.getImageList() == null || book.getImageList().size() <= 0) {
			return;
		}
		
		if(book.getBookId() == 0) {
			book.setBookId(1);
		}		
		
		book.getImageList().forEach(attach -> {
			
			attach.setBookId(book.getBookId());
			adminMapper.imageEnroll(attach);
			
		});		
		
	}

	/* 카테고리 리스트 */
	@Override
	public List<CateVO> cateList() {
		
		log.info("(service)cateList........");
		
		return adminMapper.cateList();
	}

	/* 상품 리스트 */
	@Override
	public List<BookVO> bookList(Criteria cri) {
		
		log.info("(service)bookList......." + cri);
		
		return adminMapper.bookList(cri);
	}

	/* 상품 총 개수 */
	@Override
	public int bookGetTotal(Criteria cri) {
		
		log.info("(service)bookGetTotal......" + cri);
		
		return adminMapper.bookGetTotal(cri);
	}

	/* 상품 상세 정보 */
	@Override
	public BookVO goodsGetDetail(int bookId) {
		log.info("(service)bookGetDetail......." + bookId);
		return adminMapper.goodsGetDetail(bookId);
	}

	/* 상품 정보 수정 */
	@Transactional
	@Override
	public int goodsModify(BookVO vo) {
		
		log.info("goodsModify........");
		
		adminMapper.deleteImageAll(vo.getBookId());
		
		int result = adminMapper.goodsModify(vo);
		
		List<AttachImageVO> list = vo.getImageList();
		
		if(list != null && list.size() > 0) {
			list.forEach(attach -> {
				
				attach.setBookId(vo.getBookId());
				adminMapper.imageEnroll(attach);
				
			});
			
			
		}
		
		return result;
		
	}
	
	/* 상품 정보 삭제 */
	@Override
	@Transactional
	public int goodsDelete(int bookId) {

		log.info("goodsDelete..........");
		
		adminMapper.deleteImageAll(bookId);	
		
		return adminMapper.goodsDelete(bookId);
	}		
	
	/* 지정 상품 이미지 정보 얻기 */
	@Override
	public List<AttachImageVO> getAttachInfo(int bookId) {
		
		log.info("getAttachInfo........");	
		
		return adminMapper.getAttachInfo(bookId);
	}

	@Override
	public List<OrderRequestWrapper> getOrderList(Criteria cri) {
		
		return adminMapper.getOrderList(cri);
	}

	@Override
	public int getOrderTotal(Criteria cri) {
		
		return adminMapper.getOrderTotal(cri);
	}		
	
	@Override
	@Transactional
	public void orderCancle(OrderDeleteDTO dto) {
		/* 주문, 주문상품 객체 */
			/*회원*/
				MemberVO member = memberMapper.getMemberInfo(dto.getMemberId());
			/*주문상품*/
				List<OrderRequestDTO> ords = orderMapper.getOrderItemInfo(dto.getOrderId());
				for(OrderRequestDTO ord : ords) {
					ord.initSaleTotal();
				}
			/* 주문 */
				OrderRequestWrapper orw = orderMapper.getOrder(dto.getOrderId());
				orw.setOrders(ords);
				
				orw.getOrderPriceInfo();
				
		/* 주문상품 취소 DB */
				adminMapper.orderCancle(dto.getOrderId());
				
		/* 돈, 포인트, 재고 변환 */
				/* 돈 */
				int calMoney = member.getMoney();
				calMoney += orw.getOrderFinalSalePrice();
				member.setMoney(calMoney);
				
				/* 포인트 */
				int calPoint = member.getPoint();
				calPoint = calPoint + orw.getUsePoint() - orw.getOrderSavePoint();
				member.setPoint(calPoint);
				
					/* DB적용 */
					orderMapper.deductMoney(member);
					
				/* 재고 */
				for(OrderRequestDTO ord : orw.getOrders()) {
					BookVO book = bookMapper.getGoodsInfo(ord.getBookId());
					book.setBookStock(book.getBookStock() + ord.getBookCount());
					orderMapper.deductStock(book);
				}
				
	}		

}
