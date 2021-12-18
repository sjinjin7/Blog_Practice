package com.vam.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.OrderRequestDTO;
import com.vam.model.OrderRequestWrapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class OrderMapperTests {

	@Autowired
	private OrderMapper mapper; 
	

	
	/* 주문 상품 정보(주문취소) */
	@Test
	public void getOrderItemInfoTest() {
		
		String orderId = "admin_2021120651";
		
		System.out.println("result : " + mapper.getOrderItemInfo(orderId));
	}
	
	/* 주문 정보(주문 취소) */
	@Test
	public void getOrderInfoTest() {

		String orderId = "admin_2021120651";
		
		System.out.println("result : " + mapper.getOrder(orderId));
		
	}
	
}
