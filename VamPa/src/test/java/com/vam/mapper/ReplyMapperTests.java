package com.vam.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.Criteria;
import com.vam.model.ReplyCheckDTO;
import com.vam.model.ReplyDTO;
import com.vam.model.UpdateReplyDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;
	

	
	/* 댓글 리스트 */
	@Test
	public void getReplyListTest() {
		
		Criteria cri = new Criteria();
		cri.setBookId(1);
		
		List<ReplyDTO> replyList = mapper.getReplyList(cri);
		
		System.out.println("result = " + replyList);
		
	}
	
	
	@Test
	public void checkReplyTest() {
		
		ReplyCheckDTO dto = new ReplyCheckDTO();
		dto.setBookId(8);
		dto.setMemberId("admin");
		
		Integer result = mapper.checkReply(dto);
		
		
		if(result == null) {
			System.out.println("null임");
		}
		System.out.println("================================");
		System.out.println("result : " + result);
		System.out.println("================================");
				
		
	}
	
	@Test
	public void getReplyTest() {
		
		ReplyDTO dto = new ReplyDTO();
		dto.setMemberId("admin");
		dto.setBookId(3);
		
		ReplyDTO result = mapper.getReply(dto);
		System.out.println(result);
		
	}
	

	
}
