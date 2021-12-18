package com.vam.service;

import com.vam.model.ReplyCheckDTO;
import com.vam.model.ReplyDTO;

public interface ReplyService {
	
	/* 댓글 존재 체크 */
	public Integer checkReply(ReplyCheckDTO dto);	

	/* 댓글 등록 */
	public int enrollReply(ReplyDTO dto);		
	
}
