package com.vam.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BookVO;
import com.vam.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTests {
	
	@Autowired
	private BookMapper mapper;
	
	/*
	@Test
	public void getAttachListTests() {
		
		int bookId = 25;
		
		System.out.println("result : " + mapper.getAttachList(bookId));
		
	}
	
	*/
	
	
	@Test
	public void getGoodsListTest() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("service");
		System.out.println("cri :" + cri);
		List<BookVO> bookList = mapper.getGoodsList(cri);
		
		System.out.println(bookList);
		
		int goodsTotal = mapper.goodsGetTotal(cri);
		
		System.out.println("=================");
		System.out.println("상품 갯수: " + goodsTotal);
		
		
	}
	
}
