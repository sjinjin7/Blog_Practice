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
 
 /* ===== */
 .content_main{
    //background-color: yellow;
    min-height: 700px;
    padding-right: 350px;
 }
 
 /* 사용자 정보  */
 .memberInfo_table{
    width: 100%;
    border-spacing: 0;
    border-top: 2px solid #363636;
    border-bottom: 1px solid #b6b6b6; 
 }
 .member_info_div td{
 	padding : 12px;
 	text-align: left;
 }
 /* 사용자 주소 정보 */
 .addressInfo_div{
 	margin-top: 30px;
 }
 .addressInfo_input_div_wrap{
 	border-bottom: 1px solid #f3f3f3;
 	height: 225px;
 }
.address_btn {
    background-color: #555;
    color: white;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px;
    width: 50%;
}

.address_btn:hover{
	background-color: #777;
}
.addressInfo_button_div::after{
	content:'';
	display:block;
	clear:both;
}
		.addressInfo_input_div{
			padding:12px;
			text-align: left;
			display: none;
			line-height: 40px;
		}
		.addressInfo_input_div th{
			border-color: transparent;
		    background-color: transparent;		
		}
		.addressInfo_input_div th{
			padding : 12px 5px 12px 20px;
			vertical-align: top;
		}
		.addressInfo_input_div td{
			padding : 8px 12px;
		}		
		.addressInfo_input_div_2 input{
			padding: 6px 5px;
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
			
			<div class="content_subject"><span>주문/결제</span></div>
			<div class="content_main">
				<!-- 주문자 정보 -->
				<div class="member_info_div">
					<table class="table_text_align_center memberInfo_table">
						<tbody>
							<tr>
								<th style="width: 25%;">주문자</th>
								<td style="width: *">${memberInfo.memberName} | ${memberInfo.memberMail}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 배송 정보 -->
				<div class="addressInfo_div">
					<div class="addressInfo_button_div">
						<button class="address_btn address_btn_1" onclick="showAdress('1')" style="background-color: #3c3838;">상용자 정보 주소록</button>
						<button class="address_btn address_btn_2" onclick="showAdress('2')">직접 입력</button>
					</div>
					<div class="addressInfo_input_div_wrap">
						<div class="addressInfo_input_div addressInfo_input_div_1" style="display: block">
							<table>
								<colgroup>
									<col width="25%">
									<col width="*">
								</colgroup>
								<tbody>
									<tr>
										<th>이름</th>
										<td>
											${memberInfo.memberName}
										</td>
									</tr>
									<tr>
										<th>주소</th>
										<td>
											${memberInfo.memberAddr1} ${memberInfo.memberAddr2}<br>${memberInfo.memberAddr3}
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="addressInfo_input_div addressInfo_input_div_2">
							<table>
								<colgroup>
									<col width="25%">
									<col width="*">
								</colgroup>
								<tbody>
									<tr>
										<th>이름</th>
										<td>
											<input>
										</td>
									</tr>
									<tr>
										<th>주소</th>
										<td>
											<input><br>
											<input><br>
											<input>
										</td>
									</tr>
								</tbody>
							</table>						
						</div>
					</div>
				</div>
				<!-- 주문상품 -->
				<div class="orderGoods_div">
					<table>
						<caption></caption>
					</table>
				</div>				
				<!-- 포인트 사용 -->
				<!-- 주문 최종 정보 -->
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



/* 주소입력란 버튼 동작(숨김, 등장) */
function showAdress(className){
	/* 컨텐츠 동작 */
		/* 모두 숨기기 */
			$(".addressInfo_input_div").css('display', 'none');
		/* 컨텐츠 보이기 */
			$(".addressInfo_input_div_" + className).css('display', 'block');
	/* 버튼 색상 변경 */
		/* 모든 색상 동일 */
			$(".address_btn").css('backgroundColor', '#555');
		/* 지정 색상 변경 */
			$(".address_btn_"+className).css('backgroundColor', '#3c3838');
			
			
}
	
</script>

</body>
</html>