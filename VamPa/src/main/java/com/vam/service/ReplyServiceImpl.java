package com.vam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.ReplyMapper;
import com.vam.model.Criteria;
import com.vam.model.PageDTO;
import com.vam.model.ReplyCheckDTO;
import com.vam.model.ReplyDTO;
import com.vam.model.ReplyPageDTO;
import com.vam.model.UpdateReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	/* 댓글 존재 체크 */
	@Override
	public String checkReply(ReplyCheckDTO dto) {
		
		Integer result = replyMapper.checkReply(dto);
		
		if(result == null) {
			return "0";
		} else {
			return "1";
		}
		
	}

	/* 댓글등록 */
	@Override
	public int enrollReply(ReplyDTO dto) {
		
		int result = replyMapper.enrollReply(dto); 
		
		setRating(dto.getBookId());
		
		return result;
	}

	@Override
	public ReplyPageDTO replyList(Criteria cri) {
		ReplyPageDTO dto = new ReplyPageDTO();
		
		dto.setList(replyMapper.getReplyList(cri));
		dto.setPageInfo(new PageDTO(cri, replyMapper.getReplyTotal(cri.getBookId())));
		
		return dto;
	}

	@Override
	public int updateReply(ReplyDTO dto) {
		
		int result = replyMapper.updateReply(dto); 
		
		setRating(dto.getBookId());
		
		return result;
	}

	@Override
	public int deleteReply(ReplyDTO dto) {
		
		int result = replyMapper.deleteReply(dto.getReplyId()); 
		
		setRating(dto.getBookId());
		
		return result;
	}

	@Override
	public ReplyDTO getReply(ReplyDTO dto) {
		
		return replyMapper.getReply(dto);
	}

	@Override
	public ReplyDTO getUpdateReply(int replyId) {
		
		return replyMapper.getUpdateReply(replyId);
	}
	
	
	public void setRating(int bookId) {
		Double ratingAvg = replyMapper.getRatingAverage(bookId);
		if(ratingAvg == null) {
			ratingAvg = 0.0;
		}
		UpdateReplyDTO urd = new UpdateReplyDTO();
		urd.setBookId(bookId);
		urd.setRatingAvg(ratingAvg);
		replyMapper.updateRating(urd);
	}
	

}
