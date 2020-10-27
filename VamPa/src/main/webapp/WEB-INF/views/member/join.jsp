<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/member/join.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>
<body>

<div class="wrapper">
	<form id="join_form" method="post">
	<div class="wrap">
			<div class="subjecet" onclick="test()">
				<span>회원가입</span>
			</div>
			<div class="id_wrap">
				<div class="id_name">아이디</div>
				<div class="id_input_box">
					<input class="id_input" name="memberId">
				</div>
				<span class="id_input_re_1">사용 가능한 아이디입니다.</span>
				<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
			</div>
			<div class="pw_wrap">
				<div class="pw_name">비밀번호</div>
				<div class="pw_input_box">
					<input class="pw_input" name="memberPw">
				</div>
			</div>
			<div class="pwck_wrap">
				<div class="pwck_name">비밀번호 확인</div>
				<div class="pwck_input_box">
					<input class="pwck_input">
				</div>
			</div>
			<div class="user_wrap">
				<div class="user_name">이름</div>
				<div class="user_input_box">
					<input class="user_input" name="memberName">
				</div>
			</div>
			<div class="mail_wrap">
				<div class="mail_name">이메일</div> 
				<div class="mail_input_box">
					<input class="mail_input" name="memberMail">
				</div>
				<sapn class="mail_input_box_warn"></sapn>
				<div class="mail_check_wrap">
					<div class="mail_check_input_box" id="mail_check_input_box_false">
						<input class="mail_check_input" disabled="disabled">
						<div class="code" style="display:none"></div>
					</div>
					<div class="mail_check_button">
						<span>인증번호 전송</span>
					</div>
					<div class="clearfix"></div>
					<sapn class="mail_check_input_box_warn"></sapn>
				</div>
			</div>
			<div class="address_wrap">
				<div class="address_name">주소</div>
				<div class="address_input_1_wrap">
					<div class="address_input_1_box">
						<input class="address_input_1" name="memberAddr1">
					</div>
					<div class="address_button">
						<span>주소 찾기</span>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class ="address_input_2_wrap">
					<div class="address_input_2_box">
						<input class="address_input_2" name="memberAddr2">
					</div>
				</div>
				<div class ="address_input_3_wrap" >
					<div class="address_input_3_box">
						<input class="address_input_3" name="memberAddr3">
					</div>
				</div>
			</div>
			<div class="join_button_wrap">
				
				
				<input type="button" class="join_button" value="가입하기">
				
				
				
			</div>
		</div>
	</form>
</div>
<script>

$( document ).ready( function() {
	
	// 회원가입 버튼 작동
	$(".join_button").click(function(){
		$("#join_form").attr("action","/member/join");
		$("#join_form").submit();
	});	// 회원가입 버튼 작동 종료
	


} );

// 아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function(){
	
	var memberId = $('.id_input').val();
	var data = {memberId : memberId}
	
	$.ajax({
		type : "post",
		url : "/member/memberIdChk",
		data : data,
		success : function(result){
			console.log(result);
			console.log("넘어옴?");
			if(result != 'fail'){					// 중복 아이디 없는 경우(초록색 글자)
				//alert("중복x");
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display", "none");
			} else{							// 중복 아이디 존재하는 경우(빨간색 글자)
				//alert("중복o");
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display", "none");
			}	// if 종료
			
		} // success 종료
	});	// ajax 종료	
	
}); // $('.id_input').on 종료

/*  이메일 전송 클릭 */
$(".mail_check_button").click(function(){
	
	var email = $(".mail_input").val();		// 입력한 이메일
	var warnMsg = $("");
	var cehckBox = $(".mail_check_input");
	var boxWrap = $(".mail_check_input_box");
	var code = $(".code");
	
	$.ajax({
		type:"GET",
		url:"mailCheck?email=" + email,
		success:function(data){
			console.log("data : " + data);
			cehckBox.attr("disabled",false);
			boxWrap.attr("id", "mail_check_input_box_true");
			code.html(data);
		}
				 
	});
	
	
});


/* 인증번호 비교 */
$(".mail_check_input").blur(function(){
	
	var inputCode = $(".mail_check_input").val();		// 입력코드
	var checkCode = $(".code").html();					// 이메일로 전송된 코드
	var checkResult = $(".mail_check_input_box_warn");	// 비교 결과 
	//alert(checkCode);
	//alert(inputCode);
	
	if(inputCode == checkCode){							// 일치할 경우
		
	} else {											// 일치하지 않을 경우
		
	}
	
});







</script>

</body>
</html>