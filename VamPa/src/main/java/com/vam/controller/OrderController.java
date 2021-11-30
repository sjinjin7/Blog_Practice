package com.vam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vam.model.MemberVO;
import com.vam.model.OrderRequestWrapper;

@Controller
public class OrderController {

	@GetMapping("/order/{memberId}")
	public String orderPgaeGET(@PathVariable("memberId") String memberId, OrderRequestWrapper orw, Model model, HttpServletRequest request) {
		
		//단축키 shift alt l
		HttpSession session = request.getSession();
		
		MemberVO mv = (MemberVO)session.getAttribute("member");
		
		String id = mv.getMemberId();
		
		model.addAttribute("orderList", 0);
		model.addAttribute("memberInfo", 0);
		
		
		return "/order";
	}
	
	

	
	/* 사용자 정보 */
	
	/* 상품 정보 */

	
	


}
