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
	
	/*
	@Test
	public void getGoodsInfoTest() {
		
		OrderDTO goodsInfo = mapper.getGoodsInfo(61);
		
		System.out.println(goodsInfo);
	}
	*/
	
	/* enrollOrder 테스트 */
	
	@Test
	public void enrollOrderTest() {
		
		OrderRequestWrapper orw = new OrderRequestWrapper();
		List<OrderRequestDTO> orders = new ArrayList();
		
		OrderRequestDTO ord = new OrderRequestDTO();
		
		ord.setBookId(61);
		ord.setBookCount(5);
		ord.setBookPrice(70000);
		ord.setBookDiscount(0.1);
		ord.initSaleTotal();
		
		
		
		orw.setOrders(orders);
		
		orw.setOrderId("2021_test1");
		orw.setAddressee("test");
		orw.setMemberId("admin");
		orw.setMemberAddr1("test");
		orw.setMemberAddr2("test");
		orw.setMemberAddr3("test");
		orw.setOrderState("배송중비");
		orw.getOrderPriceInfo();
		orw.setUsePoint(1000);
		System.out.println(orw.getOrderId());
		mapper.enrollOrder(orw);
		System.out.println(orw.getOrderId());
		
		
	}
	
	
	/*
	@Test
	public void enrollOrderItemTest() {
		
		OrderRequestDTO ord = new OrderRequestDTO();
		
		ord.setOrderId("2021_test");
		ord.setBookId(61);
		ord.setBookCount(5);
		ord.setBookPrice(70000);
		ord.setBookDiscount(0.1);
				
		ord.initSaleTotal();
		
		System.out.println(ord);
		
		System.out.println(ord.getOrderItemId());
		mapper.enrollOrderItem(ord);
		System.out.println(ord.getOrderItemId());
		
	}
	*/
	
	/*
	@Test
	public void deductMoneyTest() {
		MemberVO member = new MemberVO();
		member.setMemberId("admin");
		member.setMoney(500000);
		member.setPoint(10000);
		mapper.deductMoney(member);
	}
	*/
	
	/*
	@Test
	public void deductStockTest() {
		BookVO book = new BookVO();
		
		book.setBookId(61);
		book.setBookStock(77);
		
		mapper.deductStock(book);
	}
	*/
	
}
