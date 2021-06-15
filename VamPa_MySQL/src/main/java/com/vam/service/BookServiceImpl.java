package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BookMapper;
import com.vam.model.AttachImageVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	/* 이미지 데이터 반환 */
	@Override
	public List<AttachImageVO> getAttachList(int bookId) {
		
		log.info("getAttachList()........");
		
		return bookMapper.getAttachList(bookId);
		
	}

	
	
}
