package com.vam.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.AuthorVO;
import com.vam.model.BookVO;
import com.vam.model.Criteria;
import com.vam.model.PageDTO;
import com.vam.service.AdminService;
import com.vam.service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/* AuthorService */
	@Autowired
	AuthorService authorService;
	
	@Autowired
	AdminService adminService;
	
	/* 날짜 폴더 만들기 */
	
	private String getFolder() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
		
	}	
	
	/* 관리자 메인페이지 이동 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void adminMainGET() throws Exception{
		logger.info("관리자 페이지 접속");
	}
	
	/* 상품 관리 페이지 접속 */
	@RequestMapping(value = "goodsManage", method = RequestMethod.GET)
	public void goodsManageGET(Criteria cri, Model model) throws Exception{
		
		logger.info("상품 등록 페이지 접속");
		
		/* 상품 리스트 데이터 */	
		List list = adminService.bookList(cri);
		
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
			return;
		}
		/* 페이지 인터페이스 데이터 */
		model.addAttribute("pageMaker", new PageDTO(cri,adminService.bookGetTotal(cri)));
		
	}
	
	/* 상품 등록 페이지 접속 */
	@RequestMapping(value = "goodsEnroll", method = RequestMethod.GET)
	public void goodsEnrollGET(Model model) throws Exception{
		logger.info("상품 등록 페이지 접속");
		
		ObjectMapper mapper = new ObjectMapper();
		
		model.addAttribute("cateList", mapper.writeValueAsString(adminService.cateList()));
		
		System.out.println("josnTest......." + mapper.writeValueAsString(adminService.cateList()));		
		
	}
	
	/* 상품 상세, 수정 페이지 */
	@GetMapping({"/goodsDetail", "/goodsModify"})
	public void goodsGetInfo(int bookId, Criteria cri, Model model) throws JsonProcessingException {
		
		logger.info("goodsGetInfo()............" + bookId);
		
		ObjectMapper mapper = new ObjectMapper();
		
		model.addAttribute("cateList", mapper.writeValueAsString(adminService.cateList()));
		
		model.addAttribute("cri", cri);
		
		model.addAttribute("goodsInfo", adminService.goodsGetDetail(bookId));
		
	}	
	
	/* 상품 정보 수정 */
	@PostMapping("/goodsModify")
	public String goodsModifyPOST(BookVO vo, RedirectAttributes rttr) {
		
		logger.info("goodsModifyPOST.........." + vo);
		
		int result = adminService.goodsModify(vo);
		
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/goodsManage";		
		
	}
	
	/* 상품 정보 삭제 */
	@PostMapping("/goodsDelete")
	public String goodsDeletePOST(int bookId, RedirectAttributes rttr) {
		
		logger.info("goodsDeletePOST..........");
		
		int result = adminService.goodsDelete(bookId);
		
		rttr.addFlashAttribute("delete_result", result);
		
		return "redirect:/admin/goodsManage";
		
	}	
	
	/* 작가 등록 페이지 접속 */
	@RequestMapping(value = "authorEnroll", method = RequestMethod.GET)
	public void authorEnrollGET() throws Exception{
		logger.info("작가 등록 페이지 접속");
	}
	
	/* 작가 관리 페이지 접속 */
	@RequestMapping(value = "authorManage", method = RequestMethod.GET)
	public void authorManageGET(Criteria cri, Model model) throws Exception{
		
		logger.info("authorGetList......." + cri);
		
		/* 게시물 출력 데이터 */
		List list = authorService.authorGetList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list",list);	// 작가 존재 경우
		} else {
			model.addAttribute("listCheck", "empty");	// 작가 존재하지 않을 경우
		}
		
		
		/* 페이지 이동 인터페이스 데이터 */
		model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));
		
	}
	
	/* 작가 등록 */
	@RequestMapping(value="authorEnroll.do", method = RequestMethod.POST)
	public String authorEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{

		logger.info("authorEnroll :" +  author);
		
		authorService.authorEnroll(author);  	// 작가 등록 쿼리 수행
		
		rttr.addFlashAttribute("enroll_result", author.getAuthorName());	// 등록 성공 메시지(작가이름)
		
		return "redirect:/admin/authorManage";
		
	}

	/* 작가 상세 페이지 */
	@GetMapping({"/authorDetail", "/authorModify"})
	public void authorDetailGET(int authorId, Criteria cri, Model model) throws Exception {
		
		logger.info("authorDetail......." + cri);
		
		/* 목록 페이지 정보 */
		model.addAttribute("cri", cri);
		
		/* 작가 정보 */
		model.addAttribute("authorInfo", authorService.authorGetDetail(authorId));
		
	}	
	
	/* 작가 정보 수정 */
	@PostMapping("/authorModify")
	public String authorModifyPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{
		
		logger.info("authorModifyPOST.........." + author);
		
		int result = authorService.authorModify(author);
		
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/authorManage";
	}	
	
	/* 작가 정보 삭제 */
	@PostMapping("/authorDelete")
	public String authorDeletePOST(int authorId, RedirectAttributes rttr) {
		
		logger.info("authorDeletePOST..........");
		
		int result = 0;
		
		try {
			
			result = authorService.authorDelete(authorId);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			result = 2;
			rttr.addFlashAttribute("delete_result", result);
			
			return "redirect:/admin/authorManage";
			
		}
		
		
		rttr.addFlashAttribute("delete_result", result);
		
		return "redirect:/admin/authorManage";
		
	}		
	
	/* 상품 등록 */
	@PostMapping("/goodsEnroll")
	public String goodsEnrollPOST(BookVO book) {
		
		logger.info("goodsEnrollPOST......" + book);
		
		adminService.bookEnroll(book);
		
		return "redirect:/admin/goodsManage";
	}	
	
	/* 작가 검색 팝업창 */
	@GetMapping("/authorPop")
	public void authorPopGET(Criteria cri, Model model) throws Exception{
		
		logger.info("authorPopGET......." + cri);
		
		cri.setAmount(5);
		
		/* 게시물 출력 데이터 */
		List list = authorService.authorGetList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list",list);	// 작가 존재 경우
		} else {
			model.addAttribute("listCheck", "empty");	// 작가 존재하지 않을 경우
		}
		
		
		/* 페이지 이동 인터페이스 데이터 */
		model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));		
	}
	
	/* 첨부 파일 업로드 */
	@PostMapping(value="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {
		
		logger.info("uploadAjaxActionPOST..........");
		List<AttachImageVO> list = new ArrayList();
		String uploadFolder = "C:\\upload";
		
		/* 날짜 폴더 경로 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		String datePath = str.replace("-", File.separator);
		
		/* 폴더 생성 */
		File uploadPath = new File(uploadFolder, datePath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		// 향상된 for
		for(MultipartFile multipartFile : uploadFile) {
			
			AttachImageVO attachDTO = new AttachImageVO();
			
			/* 파일 이름 */
			String uploadFileName = multipartFile.getOriginalFilename();
			attachDTO.setFileName(uploadFileName);
			
			/* 이미지 타입 */
			String imageType = uploadFileName.substring(uploadFileName.indexOf(".") + 1);
			System.out.println(imageType);
			
			/* uuid 적용 파일 이름 */
			String uuid = UUID.randomUUID().toString();
			attachDTO.setUuid(uuid);
			attachDTO.setUploadPath(datePath);
			
			uploadFileName = uuid + "_" + uploadFileName;
			
			/* 파일 위치, 파일 이름을 합친 File 객체 */
			File saveFile = new File(uploadPath, uploadFileName);
			
			/* 파일 저장 */
			try {
				
				multipartFile.transferTo(saveFile);
				
				/* 썸네일 생성(ImageIO) */
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName); 
				
				BufferedImage bo_image = ImageIO.read(saveFile);

					/* 비율 */
					double ratio = 3;
					/*넓이 높이*/
					int width = (int) (bo_image.getWidth() / ratio);
					int height = (int) (bo_image.getHeight() / ratio);				
				
				BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
								
				Graphics2D graphic = bt_image.createGraphics();				
				

				
				graphic.drawImage(bo_image, 0, 0,width,height, null);
					
				ImageIO.write(bt_image, "jpg", thumbnailFile);	
				
				/* 썸네일 생성(thumbnailator) */
				/* 방법 1 */
				/*
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
				
				Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 300, 500);
				
				thumbnail.close();
				*/
				
				/* 방법 2 */
				/*
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);
				
				Thumbnails.of(saveFile)
		        .size(160, 160)
		        .toFile(thumbnailFile);
				*/
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} 
			
			list.add(attachDTO);
			
		} //for
				
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
}
