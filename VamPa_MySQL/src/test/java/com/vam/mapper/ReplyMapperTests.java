package com.vam.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.Criteria;
import com.vam.model.ReplyDTO;
import com.vam.model.UpdateReplyDTO;

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
		dto.setBookId(1);
		dto.setContent("테스트 입니다.");
		dto.setRating(1.5);
		
		mapper.enrollReply(dto);
		
	}
	
	/* 댓글 수정 테스트 */
	@Test
	public void updateReplyTest() {

		/* 댓글 세팅 */
		ReplyDTO dto = new ReplyDTO();
		dto.setReplyId(3);
		dto.setContent("수정 입니다.");
		dto.setRating(2);
		
		mapper.updateReply(dto);
		
	}
	
	/* 댓글 삭제 */
	@Test
	public void deleteReplyTest() {
		
		int replyId = 1;
		
		mapper.deleteReply(replyId);
		
	}
	
	/* 댓글 리스트 */
	@Test
	public void getReplyListTest() {
		
		Criteria cri = new Criteria();
		cri.setBookId(1);
		
		List<ReplyDTO> replyList = mapper.getReplyList(cri);
		
		System.out.println("result = " + replyList);
		
	}
	
	/* 댓글 총갯수 */
	@Test
	public void getReplyTotal() {
		
		int bookId = 1;
		
		mapper.getReplyTotal(1);
		
	}
	
	/* 평점 평균값 구하기 */
	@Test
	public void getRatingAverageTest() {
		
		int bookId = 1;
		
		mapper.getRatingAverage(bookId);
		
	}
	
	/* 평균값 반영 */
	@Test
	public void updateRating() {
		
		int updateRating = 1;
		int bookId = 1;
		
		UpdateReplyDTO dto = new UpdateReplyDTO();
		
		dto.setBookId(bookId);
		dto.setRatingAvg(updateRating);
		
		mapper.updateRating(dto);
		
	}	
	
	
	
}
