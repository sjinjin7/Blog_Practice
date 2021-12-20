package com.vam.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.Criteria;
import com.vam.model.PageDTO;
import com.vam.model.ReplyDTO;
import com.vam.service.BookService;
import com.vam.service.ReplyService;

@Controller
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;	
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public void mainPageGET(Model model) {
		
		logger.info("메인 페이지 진입");
		
		model.addAttribute("cate1", bookService.getCateCode1());
		model.addAttribute("cate2", bookService.getCateCode2());		
		
	}
	
	/* image display */
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileName) {
		
		logger.info("filename : " + fileName);
		
		File file = new File("c:\\upload\\" + fileName);
		/*
		 * "\" 특수문자 이기 때문에 \\을 해야 \슬래쉬로 인식을 함 mdn 이스케이프 문자
		 */		
		
		logger.info("file : " + file);
		
		logger.info("file path : " + file.toPath());
		
		
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();

			logger.info("Content-type : " + Files.probeContentType(file.toPath()));
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			/* 한글 경로 있을 경우를 대비하여 코딩 */
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
			
		} catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	/* 이미지 정보 반환 */
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> getAttachList(int bookId){
		
		logger.info("getAttachList..........");
		
		return new ResponseEntity<List<AttachImageVO>>(bookService.getAttachList(bookId), HttpStatus.OK);
		
	}	
	
	
	/* 상품 검색 */
	@GetMapping("search")
	public String searchGoodsGET(Criteria cri, Model model) {
		
		logger.info("cri : " + cri);
		
		List<BookVO> list = bookService.getGoodsList(cri);
		logger.info("pre list : " + list);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			logger.info("list : " + list);
		} else {
			model.addAttribute("listcheck", "empty");
			
			return "search";
		}
		
		model.addAttribute("pageMaker", new PageDTO(cri, bookService.goodsGetTotal(cri)));
		PageDTO pageInfo = new PageDTO(cri, bookService.goodsGetTotal(cri));
		String[] typeArr = cri.getType().split("");
		for(String s : typeArr) {
			if(s.equals("T") || s.equals("A")) {
				model.addAttribute("filter_info",bookService.getCateInfoList(cri));
			}
		}
		System.out.println("test ::::::::::::::::::::::::" + pageInfo.getCri().getCateCode());
		
		
		return "search";
		
	}
	
	/* 상품 상세 */
	@GetMapping("/goodsDetail/{bookId}")
	public String goodsDetailGET(@PathVariable("bookId")int bookId, Model model) {
		
		logger.info("goodsDetailGET()..........");
		
		model.addAttribute("goodsInfo", bookService.getGoodsInfo(bookId));
		
		return "/goodsDetail";
	}
	
	/* 리뷰 쓰기 */
	@GetMapping("/replyEnroll/{memberId}")
	public String replyEnrollWindowGET(@PathVariable("memberId")String memberId, int bookId, Model model) {
		BookVO book = bookService.getBookIdName(bookId);
		model.addAttribute("bookInfo", book);
		model.addAttribute("memberId", memberId);
		
		return "/replyEnroll";
	}
	
	/* 리뷰 수정 */
	@GetMapping("/replyUpdate")
	public String replyUpdateWindowGET(ReplyDTO dto, Model model) {
		BookVO book = bookService.getBookIdName(dto.getBookId());
		model.addAttribute("bookInfo", book);
		model.addAttribute("replyInfo", replyService.getUpdateReply(dto.getReplyId()));
		model.addAttribute("memberId", dto.getMemberId());
		
		return "/replyUpdate";
	}	
	
}
