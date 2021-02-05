package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vam.model.AuthorVO;
import com.vam.service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/* AuthorService */
	@Autowired
	AuthorService authorService;

	/* 관리자 메인페이지 이동 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void adminMainGET() throws Exception{
		logger.info("관리자 페이지 접속");
	}
	
	/* 상품 등록 페이지 접속 */
	@RequestMapping(value = "goodsManage", method = RequestMethod.GET)
	public void goodsManageGET() throws Exception{
		logger.info("상품 등록 페이지 접속");
	}
	
	/* 상품 등록 페이지 접속 */
	@RequestMapping(value = "goodsEnroll", method = RequestMethod.GET)
	public void goodsEnrollGET() throws Exception{
		logger.info("상품 등록 페이지 접속");
	}
	
	/* 작가 등록 페이지 접속 */
	@RequestMapping(value = "authorEnroll", method = RequestMethod.GET)
	public void authorEnrollGET() throws Exception{
		logger.info("작가 등록 페이지 접속");
	}
	
	/* 작가 관리 페이지 접속 */
	@RequestMapping(value = "authorManage", method = RequestMethod.GET)
	public void authorManageGET() throws Exception{
		logger.info("작가 관리 페이지 접속");
	}
	
	/* 작가 등록 */
	@RequestMapping(value="authorEnroll.do", method = RequestMethod.POST)
	public String authorEnrollPOST(AuthorVO author) throws Exception{
		logger.info("authorEnroll.do 진입");
		logger.info("" + author);
		
		authorService.authorEnroll(author);
		
		return "/admin/main";
	}
	
	
}
