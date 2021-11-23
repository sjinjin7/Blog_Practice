package com.vam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vam.mapper.BookMapper;
import com.vam.mapper.CartMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.CartDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class CartServiceImpl implements CartService{

	private final CartMapper cartMapper;
	
	private final BookMapper bookMapper;
	
	@Override
	public int addCart(CartDTO cart) {
		
		log.info("addCart().........");
		
		// 장바구니 데이터 체크
		CartDTO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		// 장바구니 등록 & 에러 시 0반환
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}
		
	}

	/* 장바구니 정보 리스트 */
	@Override
	public List<CartDTO> getCartList(String memberId) {
			
		log.info("getCartList().........");
		
		List<CartDTO> cart = cartMapper.getCart(memberId);
		
		for(CartDTO dto : cart) {
			/* 종합 정보 초기화 */
			dto.initSaleTotal();
			/* 이미지 정보 얻기 */
			int bookId = dto.getBookId();
			
			List<AttachImageVO> imageList = bookMapper.getAttachList(bookId);
			
			dto.setImageList(imageList);
		}
		
		return cart;
	}

	@Override
	public int modifyCount(CartDTO cart) {
		
		return cartMapper.modifyCount(cart);
	}

	
	
}
