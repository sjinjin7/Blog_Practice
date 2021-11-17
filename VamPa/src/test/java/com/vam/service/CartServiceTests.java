package com.vam.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.CartDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartServiceTests {

	@Autowired
	private CartService service; 
	
	//등록 테스트
	@Test
	public void addCartTest() {
		//given
			// 등록 가능 데이터
			String memberId = "admin";
			int bookId = 22;
			int count = 5;
			// 등록 불가능 데이터
			//String memberId = "test";
			CartDTO dto = new CartDTO(); 
			dto.setMemberId(memberId);
			dto.setBookId(bookId);
			dto.setBookCount(count);
		
		//when
			int result = service.addCart(dto);
		
		//then
			log.info("** result : " + result);
		
		
	}
	
	
}
