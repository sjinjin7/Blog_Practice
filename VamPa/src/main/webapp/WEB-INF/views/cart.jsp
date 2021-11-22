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
		.totalPrice_span{
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
								<td class="td_width_1"></td>
								<td class="td_width_2"></td>
								<td class="td_width_3">${ci.bookName}</td>
								<td class="td_width_4 price_td">
									<del>정가 : <fmt:formatNumber value="${ci.bookPrice}" pattern="#,### 원" /></del><br>
									판매가 : <span class="red_color"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원" /></span><br>
									마일리지 : <span class="green_color"><fmt:formatNumber value="${ci.salePrice * 0.05}" pattern="#,###" /></span>
								</td>
								<td class="td_width_4 table_text_align_center">
									<div class="table_text_align_center quantity_div">
										<input type="text" value="${ci.bookCount}" class="quantity_input">	
										<button class="quantity_btn plus_btn">+</button>
										<button class="quantity_btn minus_btn">-</button>
									</div>
									<a class="quantity_modify_btn">변경</a>
								</td>
								<td class="td_width_4 table_text_align_center">
									<fmt:formatNumber value="${ci.salePrice * ci.bookCount}" pattern="#,### 원" />
								</td>
								<td class="td_width_4 table_text_align_center delete_btn"><button>삭제</button></td>
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
										<td>1111원</td>
									</tr>
									<tr>
										<td>총 주문 상품수</td>
										<td>10개</td>
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
												<span class="totalPrice_span">70000</span> 원
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
				<a>주문하기</a>
			</div>
			




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
	
});	


	
</script>

</body>
</html>