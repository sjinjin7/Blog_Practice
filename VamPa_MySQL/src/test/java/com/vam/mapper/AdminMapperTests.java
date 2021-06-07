package com.vam.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMapperTests {

	@Autowired
	private AdminMapper mapper;
	
	/* 상품 등록 */
	
	@Test
	public void bookEnrollTest() throws Exception{
		
		BookVO book = new BookVO();
		
		book.setBookName("mapper 테스트");
		book.setAuthorId(123);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("202001");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("책 소개 ");
		book.setBookContents("책 목차 ");
		
		log.info("before book........" + book);
		
		mapper.bookEnroll(book);
		
		log.info("ater book........" + book);
		
	}
	
	
	/* 카테고리 리스트 */
	/*
	@Test
	public void cateListTest() throws Exception{
		
		
		
		log.info("cateList()..........." + mapper.cateList());
		
	}
	*/
	
	/* 상품 리스트 */
	/*
	@Test
	public void bookListTest() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setKeyword("웹에서");
		cri.setType("G");
		
		List list = mapper.bookList(cri);
		
		System.out.println(list);
		
	}
	*/
	
	
	/* 상품 총 개수 */
	/*
	@Test
	public void bookGetTotalTest() throws Exception{
	
		Criteria cri = new Criteria();
		cri.setType("A");
		cri.setKeyword("708");
		int result = mapper.bookGetTotal(cri);
		
		
		
		System.out.println("상품 총 개수 결과 : " + result);
		
		
	}
	*/
	
	
	/* 상품 상세 */
	/*
	@Test
	public void goodsGetDetailTest() {
		
		int bookId = 134;
		
		BookVO result = mapper.goodsGetDetail(bookId);
		
		System.out.println("상품 상페 결과 : " + result);
		
		
	}
	*/
	
	/* 상품 정보 수정 */
	/*
	@Test
	public void goodsModifyTest() {
		
		BookVO book = new BookVO();
		
		book.setBookId(169);
		book.setBookName("mapper 테스트");
		book.setAuthorId(94);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("102001");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("책 소개 ");
		book.setBookContents("책 목차 ");
		
		mapper.goodsModify(book);
		
	}
	*/
	
	/* 상품 정보 삭제 */
	/*
	@Test
	public void goodsDeleteTest() {
		
		int bookId = 169;
		
		int result = mapper.goodsDelete(bookId);
		
		if(result == 1) {
			System.out.println("삭제 성공");
		}
		
	}
	*/
	
	/* 이미지 등록 */
	/*
	@Test
	public void imageEnrollTest() {
		
		AttachImageVO vo = new AttachImageVO();
		
		vo.setBookId(137);
		vo.setFileName("test");
		vo.setUploadPath("test");
		vo.setUuid("test2");
		
		int result = mapper.imageEnroll(vo);
		
		System.out.println("result" + result);
		
	}
	*/
	
}
