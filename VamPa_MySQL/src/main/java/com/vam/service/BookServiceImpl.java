package com.vam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BookMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

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
	
	/* 상품 검색 */
	@Override
	public List<BookVO> getGoodsList(Criteria cri) {
		
		log.info("getGoodsList().......");
		
		String type = cri.getType();
		String[] typeArr = type.split("");
		String[] authorArr;
		List<BookVO> list = null;
		
		if(!type.equals("C")) {
			
			authorArr= bookMapper.getAuthorIdList(cri.getKeyword());
			
			if(type.equals("A") || type.equals("AC") || type.equals("AT") || type.equals("ACT")) {
				if(authorArr.length == 0) {
					return new ArrayList();
				}
			}
			
			for(String t : typeArr) {
				if(t.equals("A")) {
					cri.setAuthorArr(authorArr);
				}
			}					
			
		}
		
		list = bookMapper.getGoodsList(cri);
		
		list.forEach(book -> {
			
			int bookId = book.getBookId();
			
			List<AttachImageVO> imageList = bookMapper.getAttachList(bookId);
			
			book.setImageList(imageList);
			
		});		
		
		return list;
	}

	/* 사품 총 갯수 */
	@Override
	public int goodsGetTotal(Criteria cri) {
		
		log.info("goodsGetTotal().......");
		
		return bookMapper.goodsGetTotal(cri);
		
	}

	/* 국내 카테고리 리스트 */
	@Override
	public List<CateVO> getCateCode1() {
		
		log.info("getCateCode1().........");
		
		return bookMapper.getCateCode1();
	}

	/* 외국 카테고리 리스트 */
	@Override
	public List<CateVO> getCateCode2() {
		
		log.info("getCateCode2().........");
		
		return bookMapper.getCateCode2();
	}	

	
	
}
