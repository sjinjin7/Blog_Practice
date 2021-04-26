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
	/*
	@Test
	public void authorGetList() throws Exception{
		
		Criteria cri = new Criteria();
		
		cri.setKeyword("엘런");
		
		List<AuthorVO> list = mapper.authorGetList(cri);
		
		list.forEach(a -> log.info(list));
		
	}
	*/
	
	
	
	/* 전체 작가 수 */
	/*
	@Test
	public void authorGetTotal() throws Exception{
		
		Criteria cri = new Criteria();
		
		cri.setKeyword("엘런");
		
		mapper.authorGetTotal(cri);
		
	}
	*/
	
	
	
	/* 작가 상세 페이지 */
	/*
	@Test 
	public void authorGetDetailTest() {
		
		int authorId = 30;
		
		AuthorVO author = mapper.authorGetDetail(authorId);
		
		log.info("author........" + author);
		
	}
	*/
	
	/* 작가 정보 수정 */
	/*
	@Test
	public void authorModifyTest() {
		
		AuthorVO author = new AuthorVO();
		
		author.setAuthorId(1550);
		author.setAuthorName("작가이름 수정");
		author.setNationId("02");
		author.setAuthorIntro("작가 수개 내용 수정");
		
		int result = mapper.authorModify(author);
		
		log.info("result : " + result);
		
	}
	*/
	
	/* 작가 정보 삭제 */
	@Test
	public void authorDeleteTest() {
		
		
		int authorId = 44;
		
		int result = mapper.authorDelete(authorId);
		
		if(result == 1) {
			System.out.println("삭제 성공");
		}
		
	}
	
	
	
}
