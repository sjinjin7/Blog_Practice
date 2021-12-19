<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper_div">
		<div class="subject_div">
			리뷰 등록
		</div>
		<div class="input_wrap">			
			<div class="bookName_div">
				<h2>${bookInfo.bookName}</h2>
			</div>
			<div class="rating_div">
				<select name="rating">
					<option value="0.5">0.5</option>
					<option value="1.0">1.0</option>
					<option value="1.5">1.5</option>
					<option value="2.0">2.0</option>
					<option value="2.5">2.5</option>
					<option value="3.0">3.0</option>
					<option value="3.5">3.5</option>
					<option value="4.0">4.0</option>
				</select>
			</div>
			<div class="content_div">
				<textarea name="content"></textarea>
			</div>
		</div>
		<div class="btn_wrap">
			<a class="cancel_btn">취소</a><a class="enroll_btn">등록</a>
		</div>
	</div>
	
	<script>
		/* 등록 버튼 */
		$(".enroll_btn").on("click", function(e){
			const bookId = '${bookInfo.bookId}';
			const memberId = '${memberId}';
			const rating = $("select").val();
			const content = $("textarea").val();
			
			console.log("rating : " + rating);
			console.log("content : " + content);
			const data = {
					bookId : bookId,
					memberId : memberId,
					rating : rating,
					content : content
			}
			$.ajax({
				data : data,
				type : 'POST',
				url : '/reply/enroll',
				success : function(result){
					console.log('성공');
					/* 페이징 초기화 */
					window.close();
				}
				
			});
		});
		
		/* 취소 버튼 */
		$(".cancel_btn").on("click", function(e){
			window.close();
		});
	
	</script>
</body>
</html>