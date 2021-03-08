package com.vam.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.AuthorVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AuthorServiceTests {

	@Autowired
	private AuthorService service;
	
	/* 작가 정보 수정 */
	@Test
	public void authorModifyTest() throws Exception {

		AuthorVO author = new AuthorVO();
		
		author.setAuthorId(755);
		author.setAuthorName("작가이름 수정 서비스");
		author.setNationId("02");
		author.setAuthorIntro("작가 수개 내용 수정 서비스");
		
		int result = service.authorModify(author);
		
		log.info("result : " + result);		
		
	}
	
}
