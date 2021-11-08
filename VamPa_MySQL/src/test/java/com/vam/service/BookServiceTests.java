package com.vam.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BookVO;
import com.vam.model.CateFilterDTO;
import com.vam.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookServiceTests {

	
	@Autowired
	private BookService bookService;
	
	/*검색결과 카테고리 필터 정보*/
	/**
	@Test
	public void getCateFilterInfo() {
		
		Criteria cri = new Criteria();
		String type = "TC";
		String keyword = "테스트";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		
		List<CateFilterDTO> list = bookService.getCateInfoList(cri);
		
		System.out.println("list : " + list);
		
	}
 
	*/
	
	/*상품 상세 정보*/
	@Test
	public void getGoodsInfoTest() {
		
		int bookId = 137;
		
		BookVO goodsInfo = bookService.getGoodsInfo(bookId);
		
		System.out.println("==결과==");
		System.out.println("전체 : " + goodsInfo);
		System.out.println("bookId : " + goodsInfo.getBookId() );
		System.out.println("이미지 정보 : " + goodsInfo.getImageList().isEmpty());
		
		
		
	}
	
}
