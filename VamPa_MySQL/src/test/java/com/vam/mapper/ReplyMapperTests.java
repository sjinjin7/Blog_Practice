package com.vam.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.ReplyDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;	
	
	/*댓글 등록 테스트*/
	@Test
	public void enrollReplsyTest() {
		
		/* 댓글 세팅 */
		ReplyDTO dto = new ReplyDTO();
		dto.setMemberId("admin");
		dto.setBookId(7);
		dto.setContent("테스트 입니다.");
		dto.setRating(1.5);
		
		mapper.enrollReply(dto);
		
	}	
	
}
