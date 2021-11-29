package com.vam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vam.model.OrderRequestDTO;
import com.vam.model.OrderRequestWrapper;

@Controller
public class OrderController {

	@GetMapping("/order/{memberId}")
	public String orderPgaeGET(@PathVariable("memberId") String memberId, OrderRequestWrapper orw, Model model) {
		
		System.out.println("데이터 넘기기 테스트");
		System.out.println(orw.getOrders());
		System.out.println("=======");
		int index = 0;
		for(OrderRequestDTO order : orw.getOrders()) {
			System.out.println("order" + index + " : " + order);
			index += 1;
		}
		
		return "/order";
	}
	
	

	
	/* 사용자 정보 */
	
	/* 상품 정보 */

	
	


}
