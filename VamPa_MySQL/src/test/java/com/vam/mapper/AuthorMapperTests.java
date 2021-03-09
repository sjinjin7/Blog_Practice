package com.vam.mapper;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AuthorMapperTests {

	@Autowired
	private AuthorMapper mapper;
	
	/* 작가 등록 테스트 */
	/*
	@Test
	public void authorEnroll() throws Exception{
		
		AuthorVO author = new AuthorVO();
		
		author.setNationId("01");
		author.setAuthorName("테스트");
		author.setAuthorIntro("테스트 소개");
		
		mapper.authorEnroll(author);
		
	}
	*/
	
	
	/* 작가 목록 테스트 */
	
	@Test
	public void authorGetList() {
		
		Criteria cri = new Criteria();
		
		cri.setAmount(10);
		cri.setPageNum(3);
		log.info("cri............." + cri);
		
		List<AuthorVO> list = mapper.authorGetList(cri);
		log.info("list.........." + list);
		
		list.forEach(a -> log.info(list));
		
	}
	
	
	
	/* 작가 수 테스트 */
	/*
	@Test
	public void authorGetTotal() {
		
		Criteria cri = new Criteria();
		
		cri.setAmount(10);
		cri.setPageNum(2);
		log.info("cri............." + cri);
		
		mapper.authorGetTotal(cri);
		
	}
	*/
	
	
	/* 작가 디테일 페이지 */
	/*
	@Test
	public void authorGetDetailTest() {
		
		int authorId = 5;
		
		AuthorVO author = mapper.authorGetDetail(authorId);
		
		log.info("author..........." + author);
		
	}
	*/
	
	/* 작가 정보 수정 */
	/*
	@Test
	public void authorModifyTest() {
		
		AuthorVO author = new AuthorVO();
		
		author.setAuthorId(755);
		author.setAuthorName("스프링 수정");
		author.setNationId("01");
		author.setAuthorIntro("스프링에서 소개 내용 수정");
		
		int result = mapper.authorModify(author);
		
		log.info("result........." + result);
	}
	*/
	
	
}
