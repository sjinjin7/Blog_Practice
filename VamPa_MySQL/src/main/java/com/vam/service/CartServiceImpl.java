package com.vam.service;

import org.springframework.stereotype.Service;

import com.vam.mapper.CartMapper;
import com.vam.model.CartDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
	
	private final CartMapper cartMapper;
	
	@Override
	public int addCart(CartDTO cart) {
		
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

}
