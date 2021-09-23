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
		
		int bookId = 49152;
		
		System.out.println("result : " + mapper.getAttachList(bookId));
		
		
	}
	*/
	
	/* 상품 검색 */
	/*
	@Test
	public void getGoodsListTest() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("캘린더");
		System.out.println("cri :" + cri);
		List<BookVO> bookList = mapper.getGoodsList(cri);
		
		System.out.println(bookList);
		
		int goodsTotal = mapper.goodsGetTotal(cri);
		
		System.out.println("=================");
		System.out.println("상품 갯수: " + goodsTotal);
		
		
	}
	*/	
	
	
	/* 작가 id 리스트 요청 */
	/*
	@Test
	public void getAuthorId() {
		
		String keyword = "김난";
		
		String[] list = mapper.getAuthorIdList(keyword);
		
		System.out.println("결과 : " + list.toString());
		
		for(String id : list) {
			System.out.println("개별 결과 : " + id);
		}
		
		
	}
	*/

	/* 검색 (동적 쿼리 적용) - 작가*/
	/*
	@Test 
	public void getGoodsListTest1() {
		Criteria cri = new Criteria();
		String type = "A";
		String keyword = "테스트";
		String catecode = "";
		
		cri.setType(type);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		
		System.out.println("cri : " + cri);
		
		
		int total = mapper.goodsGetTotal(cri);
		
	}
	*/
	
	
	/* 검색 (동적 쿼리 적용) - 책제목*/
	/*
	@Test 
	public void getGoodsListTest2() {
		Criteria cri = new Criteria();
		String type = "T";
		String keyword = "mapper";
		String catecode = "";	
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		
		System.out.println("cri : " + cri);		
		
		List<BookVO> list = mapper.getGoodsList(cri);
		
	}
	*/
	
	
	/* 검색 (동적 쿼리 적용) - 카테고리*/
	/*
	@Test 
	public void getGoodsListTest3() {
		Criteria cri = new Criteria();
		String type = "C";
		String keyword = "";
		String catecode = "102001";		
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		System.out.println("cri : " + cri);		
		
		List<BookVO> list = mapper.getGoodsList(cri);
	}
	*/
	
	
	/* 검색 (동적 쿼리 적용) - 카테고리 + 작가 */
	/*
	@Test 
	public void getGoodsListTest4() {
		Criteria cri = new Criteria();
		String type = "AC";
		String keyword = "테스트";
		//String keyword = "머스크";
		String catecode = "102001";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		System.out.println("cri : " + cri);		
		
		List<BookVO> list = mapper.getGoodsList(cri);	
		
	}
	*/
	
	
	/* 검색 (동적 쿼리 적용) - 카테고리 + 책 제목 */
	
	@Test 
	public void getGoodsListTest5() {
		Criteria cri = new Criteria();
		String type = "CT";
		String keyword = "";
		String catecode = "102001";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		cri.setPageNum(3);
		cri.setAmount(10);
		
		System.out.println("cri : " + cri);		
		
		List<BookVO> list = mapper.getGoodsList(cri);	
		
	}
	
	
	
	/* 검색 (동적 쿼리 적용) */
	/*
	@Test 
	public void getGoodsListTest6() {
		Criteria cri = new Criteria();
		List<BookVO> resultList = mapper.getGoodsList(cri);
	}
	*/	
	
	/* 메인페이지 네비 정보 */
	/*
	@Test
	public void getCateCode1() {
		
		
		List<CateVO> cateList = mapper.getCateCode1();
		
		System.out.println(cateList);
		
	}
	*/
	
	/* 카테고리 리스트(책제목) */
	/*
	@Test
	public void getCateFilterInfoTest1() {
		
		Criteria cri = new Criteria();
		String type = "CT";
		String keyword = "수정";
		String catecode = "102001";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		mapper.getCateList(cri);
		
		System.out.println("cri : " + cri);
	}
	*/
	
	/* 카테고리 리스트(작가) */
	/*
	@Test
	public void getCateFilterInfoTest2() {
		
		Criteria cri = new Criteria();
		String type = "AC";
		String keyword = "유홍준";
		//String keyword = "머스크";
		String catecode = "102001";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		int[] cateList = mapper.getCateList(cri);
		
		System.out.println("cri : " + cri);
		System.out.println("cateList : " + cateList);
	}
	*/
	
	/* 카테고리 정보 */
	/*
	@Test
	public void getCateInfoTest1() {
		
		
		Criteria cri = new Criteria();
		String type = "CT";
		String keyword = "수정";
		String catecode = "102001";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		CateFilterDTO info = mapper.getCateInfo(cri);
		
		System.out.println("cri : " + cri);
		System.out.println("info : " + info);
		
	}
	*/
	/*
	@Test
	public void getCateInfoTest1() {
		
		
		Criteria cri = new Criteria();
		String type = "AC";
		String keyword = "유홍준";
		//String keyword = "머스크";
		String catecode = "102001";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		CateFilterDTO info = mapper.getCateInfo(cri);
		
		System.out.println("cri : " + cri);
		System.out.println("info : " + info);
		
	}
	*/
}
