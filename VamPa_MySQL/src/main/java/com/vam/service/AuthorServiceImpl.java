package com.vam.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.vam.mapper.AuthorMapper;
import com.vam.model.AuthorVO;

public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorMapper authorMapper;

	/* 작가 등록 */
	@Override
	public void authorEnroll(AuthorVO author) throws Exception {
		
		authorMapper.authorEnroll(author);
		
	}
	

}
