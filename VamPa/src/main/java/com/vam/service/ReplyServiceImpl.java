package com.vam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.ReplyMapper;
import com.vam.model.Criteria;
import com.vam.model.PageDTO;
import com.vam.model.ReplyCheckDTO;
import com.vam.model.ReplyDTO;
import com.vam.model.ReplyPageDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	/* 댓글 존재 체크 */
	@Override
	public Integer checkReply(ReplyCheckDTO dto) {
		
		return replyMapper.checkReply(dto);
	}

	/* 댓글등록 */
	@Override
	public int enrollReply(ReplyDTO dto) {
		
		return replyMapper.enrollReply(dto);
	}

	@Override
	public ReplyPageDTO replyList(Criteria cri) {
		ReplyPageDTO dto = new ReplyPageDTO();
		
		dto.setList(replyMapper.getReplyList(cri));
		dto.setPageInfo(new PageDTO(cri, replyMapper.getReplyTotal(cri.getBookId())));
		
		return dto;
	}
	
	

}
