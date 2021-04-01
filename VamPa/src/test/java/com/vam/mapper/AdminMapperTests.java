package com.vam.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMapperTests {

	@Autowired
	private AdminMapper mapper;
	
	/* 상품 등록 */
	/*
	@Test
	public void bookEnrollTest() throws Exception{
		
		BookVO book = new BookVO();
		
		book.setBookName("mapper 테스트");
		book.setAuthorId(123);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("0231");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("책 소개 ");
		book.setBookContents("책 목차 ");
		
		log.info("book........" + book);
		
		mapper.bookEnroll(book);
	}
	*/
	
	/* 카테고리 리스트 */
	/*
	@Test
	public void cateListTest() throws Exception{
		
		
		
		log.info("cateList()..........." + mapper.cateList());
		
	}
	*/
	
	/* 상품 리스트 */
	
	@Test
	public void goodsListTest() {
	
		Criteria cri = new Criteria();
	
		
		List list = mapper.bookList(cri);
		
		System.out.println(list);
		
		
	}
	
	
	/* 상품 총 갯수 */
	@Test
	public void bookGetTotalTest() {
		
		Criteria cri = new Criteria();
		cri.setType("C");
		cri.setKeyword("201001");
		int result = mapper.bookGetTotal(cri);
		
		
		
		System.out.println("총 갯수 결과 값 : " + result);
		
	}
	
	
}
