<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<link rel="stylesheet" href="../resources/css/cart.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
 <style type="text/css">
 .content_subject{
	height: 110px;
    line-height: 110px;
    background-color: #5080bd;
    margin-bottom: 60px; 
 
 }
	 .content_subject span{ 
	    padding-left: 30 px;
	    display: inline-block;
	    color: white;
	    font-size: 50px;
	    font-weight: bolder; 
	 }
 
 .content_totalCount_section{
 	margin-bottom: 12px;
 }
 .content_btn_section{
 	margin-top: 20px;
 	text-align: right;
 }
 	.content_btn_section a{
    color: #fefeff;
    background-color: #365fdd;
    min-width: 125px;
    padding: 17px 25px;
    display: inline-block;
    height: 39px;
    font-size: 23px;
    font-weight: bold;
    text-align: center;
    margin-right: 14px;
    line-height: 39px; 	
 	}
 
 /* ㅁㅁ */
 table{
 	border-collapse: collapse;
 	width: 100%;
 }
 table_text_align_center{
			text-align: center;
 }
 .subject_table{
	font-size: 14px;
    line-height: 20px;
    width: 100%;
    text-align: center; 	
 }
	 caption{
	    visibility: hidden;
	    width: 0;
	    height: 0;
	    font-size: 0;
	    line-height: 0;
	    overflow: hidden; 
	 }
	 th{
	text-align: center;
    color: #333;
    border-bottom: 1px solid #e7e7e7;
    border-top: 1px solid #3084d9;
    background: #f4f9fd;
    padding: 2px 0;	 
	 }
	.td_width_1{
		width: 5%;
	}	 	 	 
	.td_width_2{
		width: 10%;
	}	 	 
	.td_width_3{
		width: 25%;
	}	 
	.td_width_4{
		width: 15%;
	}	
	.cart_table{
		font-size: 14px;
		line-height: 20px;
	}  
		.cart_table tr{
			height: 110px;
		}
		.price_td{
			padding-left: 5px;
		}
			.red_color{
				color : red;
			}
			.green_color{
				color : green;
			}
		.cart_table td{
			border-bottom: 1px solid #e7e7e7;
		}
		.quantity_div{
			position: relative;
		    width: 42px;
		    height: 25px;
		    text-align: left;
		    margin: 5px auto;		
		}
		.quantity_input{
			position: absolute;
			width: 27px;
		    height: 23px;
		    text-align: center;
		    border: 1px solid #c6c6c6;
		    border-right: 0px;
		    line-height: 19px;
		    font-size: 12px;
		    color: #4c4848;	
		    left: 0;
		}
		.quantity_btn{
			position: absolute;
		    border: 1px solid #aaa;
		    color: #3a60df;
		    width: 14px;
		    height: 13px;
		    padding: 0px;
		    background-color: #fff;
		    font-weight: bold;
		    font-size: 7px;
		    line-height: 6px;
		    vertical-align: middle;	
		}
		.plus_btn{
			top: 0;
			right: 0
		}
		.minus_btn{
			bottom: 0;
			right: 0
		}		
		.quantity_modify_btn{
			border: 1px solid #d0d0d0;
		    height: 13px;
		    line-height: 13px;
		    background-color: #fff;
		    text-align: center;
		    width: 28px;
		    display: inline-block;
		    padding: 3px 6px 2px;
		    margin-top: 3px;		
		}
		.table_text_align_center{
			text-align: center;
		}
		.delete_btn{
			width: 40px;		
		}
		
.content_total_section{
	    background-color: rgb(227, 237, 247);
}		
	.total_wrap{
		width: 80%;
	    margin: auto;
	    padding: 10px 0 10px 0;	
	}
		.total_wrap td{
			width : 50%;
		}
		.finalTotalPrice_span{
			color: #854A72;
			font-size: 17px;
			font-weight: bold;
		}
		.totalPoint_span{
			font-size: 17px;
			font-weight: bold;		
		}
		.boundary_div{
			font-size: 0;
		    border: 1px dotted #d1c7c7;
		    margin: 5px 0 5px 0;		
		}
		.input_size_20{
			width:20px;
			height:20px;
		}
		.all_check_input{
			margin: 18px 0 18px 18px;
		}
		.all_chcek_span{
			padding-left: 8px;
	    	font-size: 20px;
	    	font-weight: bold;		
		}
		
		/* 이미지 */
		.image_wrap{
			width: 100%;
			height: 100%;
		}
		.image_wrap img{
		    max-width: 85%;
		    height: auto;
		    display: block;		
		}
		

 </style>
</head>
<body>

<div class="wrapper">
	<div class="wrap">
		<!-- gnv_area -->	
		<div class="top_gnb_area">
			<ul class="list">	
				<c:if test="${member == null }">	<!-- 로그인 x -->
					<li >
						<a href="/member/login">로그인</a>
					</li>
					<li>
						<a href="/member/join">회원가입</a>
					</li>
				</c:if>
				<c:if test="${member != null }">	<!-- 로그인 o -->
					<c:if test="${member.adminCk == 1 }">
						<li><a href="/admin/main">관리자 페이지</a></li>
					</c:if>				
					<li><a id="gnb_logout_button">로그아웃</a></li>
					<li>마이룸</li>
					<li>장바구니</li>
				</c:if>
				<li>고객센터</li>			
			</ul>
		</div>
		<!-- top_area -->
		<div class="top_area">
			<!-- 로고영역 -->
			<div class="logo_area">
				<a href="/main"><img src="/resources/img/mLogo.png"></a>
			</div>
			<div class="search_area">
                	<div class="search_wrap">
                		<form id="searchForm" action="/search" method="get">
                			<div class="search_input">
                				<select name="type">
                					<option value="T" selected="selected">책 제목</option>
                					<option value="A">작가</option>
                				</select>
                				<input type="text" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>">
                    			<button class='btn search_btn'>검 색</button>                				
                			</div>
                		</form>
                	</div>
			</div>
			<!-- 로그인 영역 -->
			<div class="login_area">
				<c:if test="${member == null}">
				
					<div class="login_button"><a href="/member/login">로그인</a></div>
					<span><a href="/member/join">회원가입</a></span>
				
				</c:if>
				<c:if test="${member != null}">
					<div class="login_success_area">
						<span>회 원 : ${member.memberName}</span>
						<span>충전금액 : <fmt:formatNumber value="${member.money }" pattern="\#,###.##"/> </span>
						<span>포인트 : <fmt:formatNumber value="${member.point }" pattern="#,###" /></span>
						<a href="/member/logout.do">로그아웃</a>
					</div>
				</c:if>
				
			</div>
			<div class="clearfix"></div>			
		</div>
		

		<div class="content_area">
			
			<div class="content_subject"><span>장바구니</span></div>
			<!-- 장바구니 리스트 -->
			<div class="content_middle_section"></div>
			<!-- 장바구니 가격 합계 -->
			<!-- cartInfo -->
			<div class="content_totalCount_section">
				<!-- 체크박스 전체 여부 -->
				<div class="all_check_input_div">
					<input type="checkbox" class="all_check_input input_size_20" checked="checked"><span class="all_chcek_span">전체선택</span>
				</div>
				
				<table class="subject_table">
					<caption>표 제목 부분</caption>
					<tbody>

						<tr>
							<th class="td_width_1"></th>
							<th class="td_width_2"></th>
							<th class="td_width_3">상품명</th>
							<th class="td_width_4">가격</th>
							<th class="td_width_4">수량</th>
							<th class="td_width_4">합계</th>
							<th class="td_width_4">삭제</th>
						</tr>
					</tbody>
				</table>
				<table class="cart_table">
					<caption>표 내용 부분</caption>
					<tbody>
						<c:forEach items="${cartInfo}" var="ci">
							<tr>
								<td class="td_width_1 table_text_align_center cart_info_td" > 
									<input type="checkbox" class="indibidual_cart_checkbox input_size_20" checked="checked">
									<input type="hidden" class="individual_bookPrice_input" value="${ci.bookPrice}">
									<input type="hidden" class="individual_salePrice_input" value="${ci.salePrice}">
									<input type="hidden" class="individual_bookCount_input" value="${ci.bookCount}">
									<input type="hidden" class="individual_totalPrice_input" value="${ci.salePrice * ci.bookCount}">
									<input type="hidden" class="individual_point_input" value="${ci.point}">
									<input type="hidden" class="individual_totalPoint_input" value="${ci.totalPoint}">
									<input type="hidden" class="individual_bookId_input" value="${ci.bookId}">
								</td>
								<!-- 상품 이미지 -->
								<td class="td_width_2">
									<div class="image_wrap" data-bookid="${ci.imageList[0].bookId}" data-path="${ci.imageList[0].uploadPath}" data-uuid="${ci.imageList[0].uuid}" data-filename="${ci.imageList[0].fileName}">
										<img>
									</div>									
								</td>
								<td class="td_width_3">${ci.bookName}</td>
								<td class="td_width_4 price_td">
									<del>정가 : <fmt:formatNumber value="${ci.bookPrice}" pattern="#,### 원" /></del><br>
									판매가 : <span class="red_color"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원" /></span><br>
									마일리지 : <span class="green_color"><fmt:formatNumber value="${ci.point}" pattern="#,###" /></span>
								</td>
								<td class="td_width_4 table_text_align_center">
									<div class="table_text_align_center quantity_div">
										<input type="text" value="${ci.bookCount}" class="quantity_input">	
										<button class="quantity_btn plus_btn">+</button>
										<button class="quantity_btn minus_btn">-</button>
									</div>
									<a class="quantity_modify_btn" data-cartId="${ci.cartId}">변경</a>
								</td>
								<td class="td_width_4 table_text_align_center">
									<fmt:formatNumber value="${ci.salePrice * ci.bookCount}" pattern="#,### 원" />
								</td>
								<td class="td_width_4 table_text_align_center"><button class="delete_btn" data-cartid="${ci.cartId}">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="list_table">
				</table>
			</div>
			<!-- 가격 종합 -->
			<div class="content_total_section">
				<div class="total_wrap">
					<table>
						<tr>
							<td>
								<table>
									<tr>
										<td>총 상품 가격</td>
										<td>
											<span class="totalPrice_span">70000</span> 원
										</td>
									</tr>
									<tr>
										<td>배송비</td>
										<td>
											<span class="delivery_price">3000</span>원
										</td>
									</tr>									
									<tr>
										<td>총 주문 상품수</td>
										<td><span class="totalKind_span"></span>종 <span class="totalCount_span"></span>권</td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td>상품 마일리지</td>
										<td>250원</td>
									</tr>
								</table>							
							</td>
						</tr>
					</table>
					<div class="boundary_div">구분선</div>
					<table>
						<tr>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>총 결제 예상 금액</strong>
											</td>
											<td>
												<span class="finalTotalPrice_span">70000</span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>총 적립 예상 마일리지</strong>
											
											</td>
											<td>
												<span class="totalPoint_span">70000</span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 구매 버튼 영역 -->
			<div class="content_btn_section">
				<a class="order_btn">주문하기</a>
			</div>
			

			<!-- 수량 조정 form -->
			<form action="/cart/update" method="post" class="quantity_update_form">
				<input type="hidden" name="cartId" class="update_cartId">
				<input type="hidden" name="bookCount" class="update_bookCount">
				<input type="hidden" name="memberId" value="${cartInfo[0].memberId}">
			</form>
			<!-- 삭제 form -->
			<form action="/cart/delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="cartId" class="delete_cartId">
				<input type="hidden" name="memberId" value="${cartInfo[0].memberId}">
			</form>			
			<!-- 주문 form -->
			<form action="/order/${member.memberId}" method="get" class="order_form">

			</form>			


		</div>
		<!-- Footer 영역 -->
		<div class="footer_nav">
			<div class="footer_nav_container">
				<ul>
					<li>회사소개</li>
					<span class="line">|</span>
					<li>이용약관</li>
					<span class="line">|</span>
					<li>고객센터</li>
					<span class="line">|</span>
					<li>광고문의</li>
					<span class="line">|</span>
					<li>채용정보</li>
					<span class="line">|</span>
				</ul>
			</div>
		</div> <!-- class="footer_nav" -->
		
		<div class="footer">
			<div class="footer_container">
				
				<div class="footer_left">
					<img src="/resources/img/Logo.png">
				</div>
				<div class="footer_right">
					(주) VamBook    대표이사 : OOO
					<br>
					사업자등록번호 : ooo-oo-ooooo
					<br>
					대표전화 : oooo-oooo(발신자 부담전화)
					<br>
					<br>
					COPYRIGHT(C) <strong>kimvampa.tistory.com</strong>	ALL RIGHTS RESERVED.
				</div>
				<div class="clearfix"></div>
			</div>
		</div> <!-- class="footer" -->
	</div>
</div>

<script>
// 검색 타입 selected
$(document).ready(function(){
	
	/* 이미지 삽입 */
	const bobj = $(".image_wrap");
	
	if(bobj.data("bookid")){
		const uploadPath = bobj.data("path");
		const uuid = bobj.data("uuid");
		const fileName = bobj.data("filename");
		
		const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
		
		bobj.find("img").attr('src', '/display?fileName=' + fileCallPath);
	} else {
		bobj.find("img").attr('src', '/resources/img/goodsNoImage.png');
	}	
	
	/* totalInfo(가격, 권수, 종류, 포인트) 셋팅 */
	setTotalInfo($(".cart_info_td"));
	
	/* 이미지 삽입 */
	$(".image_wrap").each(function(i, obj){
		
		const bobj = $(obj);
		
		if(bobj.data("bookid")){
			const uploadPath = bobj.data("path");
			const uuid = bobj.data("uuid");
			const fileName = bobj.data("filename");
			
			const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
			
			$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
		} else {
			$(this).find("img").attr('src', '/resources/img/goodsNoImage.png');
		}
		
	});
	
});	

/* 체크여부에따른 종합 정보 변화 */
$(".indibidual_cart_checkbox").on("change", function(){
	/* totalInfo(가격, 권수, 종류, 포인트) 셋팅 */
	setTotalInfo($(".cart_info_td"));
});

/* 체크박스 전체 선택 */
$(".all_check_input").on("click", function(){

	/* 체크박스 체크/해제 */
	if($(".all_check_input").prop("checked")){
		$(".indibidual_cart_checkbox").attr("checked", true);
	} else{
		$(".indibidual_cart_checkbox").attr("checked", false);
	}
	
	/* 종합정보 세팅 */
	setTotalInfo($(".cart_info_td"));
	
});









/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
function setTotalInfo(cartObj){
	
	let totalPrice = 0;				// 총 가격
	let totalCount = 0;				// 총 갯수
	let totalKind = 0;				// 총 종류
	let totalPoint = 0;				// 총 마일리지
	let deliveryPrice = 0;			// 배송비
	let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)

	
	cartObj.each(function(index, element){
		
		if($(element).find(".indibidual_cart_checkbox").is(":checked") === true){	//체크여부
			// 총 가격
			totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
			// 총 갯수
			totalCount += parseInt($(element).find(".individual_bookCount_input").val());
			// 총 종류
			totalKind += 1;
			// 총 마일리지
			totalPoint += parseInt($(element).find(".individual_totalPoint_input").val());			
		}

	});
	
	
	/* 배송비 결정 */
	if(totalPrice >= 30000){
		deliveryPrice = 0;
	} else if(totalPrice == 0){
		deliveryPrice = 0;
	} else {
		deliveryPrice = 3000;	
	}
	
		finalTotalPrice = totalPrice + deliveryPrice;
	
	/* ※ 세자리 컴마 Javscript Number 객체의 toLocaleString() */
	
	// 총 가격
	$(".totalPrice_span").text(totalPrice.toLocaleString());
	// 총 갯수
	$(".totalCount_span").text(totalCount);
	// 총 종류
	$(".totalKind_span").text(totalKind);
	// 총 마일리지
	$(".totalPoint_span").text(totalPoint.toLocaleString());
	// 배송비
	$(".delivery_price").text(deliveryPrice);	
	// 최종 가격(총 가격 + 배송비)
	$(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());		
}

/* 수량버튼 */
$(".plus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	$(this).parent("div").find("input").val(++quantity);
});
$(".minus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	if(quantity > 1){
		$(this).parent("div").find("input").val(--quantity);		
	}
});

/* 수량 수정 버튼 */
$(".quantity_modify_btn").on("click", function(){
	let cartId = $(this).data("cartid");
	let bookCount = $(this).parent("td").find("input").val();
	$(".update_cartId").val(cartId);
	$(".update_bookCount").val(bookCount);
	$(".quantity_update_form").submit();
	
});

/* 장바구니 삭제 버튼 */
$(".delete_btn").on("click", function(e){
	e.preventDefault();
	const cartId = $(this).data("cartid");
	$(".delete_cartId").val(cartId);
	$(".quantity_delete_form").submit();
});
	

/* 주문 페이지 이동 */	
$(".order_btn").on("click", function(){
	let orderNumber = 0;
	let form_contents ='';
	$(".cart_info_td").each(function(index, element){
		
		
		if($(element).find(".indibidual_cart_checkbox").is(":checked") === true){	//체크여부
			let bookId = $(element).find(".individual_bookId_input").val();
			let bookCount = $(element).find(".individual_bookCount_input").val();
			let bookId_input = "<input name='orders[" + index + "].bookId' type='hidden' value='" + bookId + "'>";
			form_contents += bookId_input;
			let bookCount_input = "<input name='orders[" + index + "].bookCount' type='hidden' value='" + bookCount + "'>";
			form_contents += bookCount_input;
		}
	});
	$(".order_form").html(form_contents);
	$(".order_form").submit();
});
	
</script>

</body>
</html>