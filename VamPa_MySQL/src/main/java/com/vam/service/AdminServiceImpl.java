package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.AdminMapper;
import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	/* 상품 등록 */
	@Override
	public void bookEnroll(BookVO book) {
		
		log.info("(srevice)bookEnroll........");
		
		adminMapper.bookEnroll(book);
		
	}

	/* 카테고리 리스트 */
	@Override
	public List<CateVO> cateList() {
		
		log.info("(service)cateList........");
		
		return adminMapper.cateList();
	}

	/* 상품 리스트 */
	@Override
	public List<BookVO> bookList(Criteria cri) {
		
		log.info("(service)bookList......." + cri);
		
		return adminMapper.bookList(cri);
	}

	/* 상품 총 개수 */
	@Override
	public int bookGetTotal(Criteria cri) {
		
		log.info("(service)bookGetTotal......" + cri);
		
		return adminMapper.bookGetTotal(cri);
	}


}