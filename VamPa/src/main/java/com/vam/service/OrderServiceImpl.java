package com.vam.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.mapper.BookMapper;
import com.vam.mapper.CartMapper;
import com.vam.mapper.MemberMapper;
import com.vam.mapper.OrderMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CartDTO;
import com.vam.model.MemberVO;
import com.vam.model.OrderDTO;
import com.vam.model.OrderRequestDTO;
import com.vam.model.OrderRequestWrapper;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<OrderDTO> getGoodsInfo(List<OrderRequestDTO> orders) {
		
		List<OrderDTO> result = new ArrayList<OrderDTO>();
		
		for(OrderRequestDTO ord : orders) {
			OrderDTO goodsInfo = orderMapper.getGoodsInfo(ord.getBookId());
			goodsInfo.setBookCount(ord.getBookCount());
			goodsInfo.initSaleTotal();
			
			List<AttachImageVO> imageList = bookMapper.getAttachList(goodsInfo.getBookId());
			
			goodsInfo.setImageList(imageList);
			
			result.add(goodsInfo);
		}
		
		return result;
	}

	@Override
	@Transactional
	public void order(OrderRequestWrapper orw) {
		//사용할 데이터가져오기
			// member
				MemberVO member = memberMapper.getMemberInfo(orw.getMemberId());
			// orderItemDTO
				List<OrderRequestDTO> ords = new ArrayList<>();
				for(OrderRequestDTO ord : orw.getOrders()) {
					OrderRequestDTO orderItem = orderMapper.getOrderInfo(ord.getBookId());
					// 수량 셋팅
						orderItem.setBookCount(ord.getBookCount());
					// 기본정보 셋팅
						orderItem.initSaleTotal();
					//List객체 추가
						ords.add(orderItem);
				}
			// OrderRequestWrapper 셋팅
				orw.setOrders(ords);
				orw.getOrderPriceInfo();
				
				System.out.println("결과 ======================");
				System.out.println(orw);
				System.out.println("=========================");
		//주문, 주문상품 객체 생성(or 배송정보생성)
		//DB 주문,주문상품(,배송정보) 넣기
				/* orderId만들기 */
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
					String orderId = member.getMemberId() + format.format(date);
					orw.setOrderId(orderId);
				/* db넣기 */
				orderMapper.enrollOrder(orw);
				for(OrderRequestDTO ord : orw.getOrders()) {
					ord.setOrderId(orderId);
					orderMapper.enrollOrderItem(ord);
				}
		//비용 차감, 회사 수익 증가
		//예외 적용 필요
				int calMoney = member.getMoney();
				calMoney -= orw.getOrderFinalSalePrice();
				member.setMoney(calMoney);
		//포인트 차감, 포인트 증가
				int calPoint = member.getPoint();
				/* 포인트 차감 *//* 구매 포인트 증가 */
				calPoint = calPoint - orw.getUsePoint() + orw.getOrderSavePoint();
				member.setPoint(calPoint);
		//비용, 포인트 DB 적용
				orderMapper.deductMoney(member);
				
		//재고차감
				for(OrderRequestDTO ord : orw.getOrders()) {
					BookVO book = bookMapper.getGoodsInfo(ord.getBookId());
					book.setBookStock(book.getBookStock() - ord.getBookCount());
					orderMapper.deductStock(book);
				}
				
		//장바구니 제거
			for(OrderRequestDTO ord : orw.getOrders()) {
				CartDTO dto = new CartDTO();
				dto.setMemberId(orw.getMemberId());
				dto.setBookId(ord.getBookId());
				
				cartMapper.deleteOrderCart(dto);
			}
		
	}
	
	

}
