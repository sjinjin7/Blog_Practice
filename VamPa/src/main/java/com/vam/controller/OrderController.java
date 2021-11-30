package com.vam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vam.model.MemberVO;
import com.vam.model.OrderRequestWrapper;
import com.vam.service.MemberService;
import com.vam.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/order/{memberId}")
	public String orderPgaeGET(@PathVariable("memberId") String memberId, OrderRequestWrapper orw, Model model) {
		
		System.out.println("memberId : " + memberId);
		System.out.println("orders : " + orw.getOrders());
		
		model.addAttribute("orderList", orderService.getGoodsInfo(orw.getOrders()));
		model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));
		
		
		return "/order";
	}
	
	

	
	/* 사용자 정보 */
	
	/* 상품 정보 */

	
	


}
