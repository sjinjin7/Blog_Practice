package com.vam.service;

import com.vam.model.Criteria;
import com.vam.model.ReplyCheckDTO;
import com.vam.model.ReplyDTO;
import com.vam.model.ReplyPageDTO;

public interface ReplyService {
	
	/* 댓글 존재 체크 */
	public Integer checkReply(ReplyCheckDTO dto);	

	/* 댓글 등록 */
	public int enrollReply(ReplyDTO dto);	
	
	/* 댓글 페이징 */
	public ReplyPageDTO replyList(Criteria cri);	
	
	/* 댓글 수정 */
	public int updateReply(ReplyDTO dto);	
	
	/* 댓글 삭제 */
	public int deleteReply(int replyId);		
	
}
