<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<jsp:include page="include/link.html" />

<link rel="stylesheet" href="css/signup.css">
<script src="js/modifyInfo.js" defer></script>


</head>
<body>
	<div class='wrap'>
		<jsp:include page="include/header.jsp" />

		<div id="contents">
			<form method="post" action="modifyInfoForm.user" name="modifyForm" id='modifyForm'>
				<div class='signup'>
					<div class="title">
						<h3>회원 정보 수정</h3>
						<input type="hidden" id="userid" value="${userDTO.mid}" name="mid">
					</div>

					<div class="user">
						<p class="main-text">이름</p>
						<input type="text" placeholder="이름" class="name" id='username' name="mname" value="${userDTO.mname}" required>
						<p class='sub-text'>한글 이름 2~4자 이내, 영문 이름 2~10자 이내</p>
						<p class="error-text"></p>
					</div>

					<div class="pw">
						<p class="main-text">비밀번호</p>
						<input type="password" placeholder="기존비밀번호" class="password" id='userpw'>
						<p class="error-text"></p>
						
						<input type="password" placeholder="새 비밀번호" class="newpassword_ok" id='newuserpw' name="newmpw">
						<p class="error-text new"></p>
						<input type="password" placeholder="새 비밀번호확인" class="newpassword_ok" id='newuserpwOk' >
						<p class="sub-text">6~20자 / 영문 대문자, 소문자, 숫자, 특수문자 사용 가능</p>
						<p class="error-text newduple"></p>
					</div>


					<div class="ok">
						<button id='register' onclick="modify()">변경하기</button>
					</div>
				</div>
			</form>
		</div>
		<!-- contents영역종료 -->

		<jsp:include page="include/footer.html" />

	</div>
</body>
</html>