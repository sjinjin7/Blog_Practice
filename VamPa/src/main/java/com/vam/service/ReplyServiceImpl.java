package com.vam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.ReplyMapper;
import com.vam.model.ReplyCheckDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	/* 댓글 존재 체크 */
	@Override
	public Integer checkReply(ReplyCheckDTO dto) {
		
		return replyMapper.checkReply(dto);
	}
	
	

}
