package com.vam.service;

import com.vam.model.ReplyCheckDTO;

public interface ReplyService {
	
	/* 댓글 존재 체크 */
	public Integer checkReply(ReplyCheckDTO dto);

}
