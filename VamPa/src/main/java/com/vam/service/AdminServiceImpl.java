package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.mapper.AdminMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	/* 상품 등록 */
	@Transactional
	@Override
	public void bookEnroll(BookVO book) {
		
		log.info("(srevice)bookEnroll........");
		
		adminMapper.bookEnroll(book);
		
		if(book.getImageList() == null || book.getImageList().size() <= 0) {
			return;
		}
		
		if(book.getBookId() == 0) {
			book.setBookId(1);
		}
		
		book.getImageList().forEach(attach -> {
			
			attach.setBookId(book.getBookId());
			adminMapper.imageEnroll(attach);
			
		});
		
	}

	/* 카테고리 리스트 */
	@Override
	public List<CateVO> cateList() {
		
		log.info("(service)cateList........");
		
		return adminMapper.cateList();
	}

	/* 상품 리스트 */
	@Override
	public List<BookVO> goodsGetList(Criteria cri) {
		
		log.info("(service)bookList......." + cri);
		
		return adminMapper.goodsGetList(cri);
	}

	/* 상품 총 개수 */
	@Override
	public int goodsGetTotal(Criteria cri) {
		
		log.info("(service)bookGetTotal......" + cri);
		
		return adminMapper.goodsGetTotal(cri);
	}

	/* 상품 상세 정보 */
	@Override
	public BookVO goodsGetDetail(int bookId) {
		log.info("(service)bookGetDetail......." + bookId);
		return adminMapper.goodsGetDetail(bookId);
	}

	/* 상품 정보 수정 */
	@Transactional
	@Override
	public int goodsModify(BookVO vo) {
		
		log.info("goodsModify........");
		
		adminMapper.deleteImageAll(vo.getBookId());
		
		int result = adminMapper.goodsModify(vo);
		
		List<AttachImageVO> list = vo.getImageList();
		
		if(list != null && list.size() > 0) {
			list.forEach(attach -> {
				
				attach.setBookId(vo.getBookId());
				adminMapper.imageEnroll(attach);
				
			});
			
			
		}
		
		return result;
		
	}

	/* 상품 정보 삭제 */
	@Override
	public int goodsDelete(int bookId) {

		log.info("goodsDelete..........");
		
		return adminMapper.goodsDelete(bookId);
	}		
	
}
