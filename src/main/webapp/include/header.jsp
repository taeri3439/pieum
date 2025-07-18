<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<header id="header">
		<div class="left">
			<a href="#" class="logo"><img src="img2/logo.png" alt="#"></a>
		</div>
		<div class="right">
				<c:choose>
					<c:when test="${sessionScope.userDTO != null }">
						<a href="logout.user" style="margin-right:60px; font-size:10px;">로그아웃</a>
					</c:when>
				</c:choose>
			<a href="list.capsule" class="searchBtn"><img
				src="img2/search.png" alt="" class="icon"></a> <a href="#"
				class="menubar"> <span></span> <span></span> <span></span>
			</a>
		</div>
	</header>

	<div class="menu">
		<div class="closeBtn flex">
			<div class="settings">
				<a href="#" class="closed"> <span class="closedX"></span> <span
					class="closedX"></span>
				</a>
			</div>
			<div class="settings">
				<!-- Additional settings can be added here -->
			</div>
		</div>

		<div class="myinfoWrap flex">
			<div class="photo">
				<img src="img2/ex.jpg" alt="">
			</div>
			<div class="myinfo"> 
				<p class="userId">
				<c:choose>
					<c:when test="${sessionScope.userDTO == null }">
						<a href="login.user">로그인을 해주세요.</a>
					</c:when>
					<c:otherwise>
						${userDTO.mid}
					</c:otherwise>		
				</c:choose>
				</p>
				<p class="alter">
					<c:if test="${not empty sessionScope.userDTO}">
						<a href="#" class='alterInfo'>프로필편집 ></a>
					</c:if>
				</p>
			</div>
		</div>

		<!-- 햄버거 메뉴 -->
		<div class="menuIconWrap">
			<div class="flex" style="margin-bottom: 40px;">
				<div class="menuIcon mygroupIcon">
					<div class="flex">
						<img src="img2/group.png" alt="">
						<p>그룹</p>
					</div>
				</div>
				<div class="menuIcon homeIcon">
					<div class="flex">
						<img src="img2/home.png" alt="">
						<p>홈</p>
					</div>
				</div>
				<div class="menuIcon mypageIcon">
					<div class="flex">
						<img src="img2/person.png" alt="">
						<p>마이페이지</p>
					</div>
				</div>
			</div>

			<div class="flex">
				<div class="menuIcon consultIcon">
					<div class="flex">
						<img src="img2/inquiry.png" alt="">
						<p>문의하기</p>
					</div>
				</div>
				<div class="menuIcon myConsultIcon">
					<div class="flex">
						<img src="img2/inquiryList.png" alt="">
						<p>문의내역</p>
					</div>
				</div>
				<div class="menuIcon anounceIcon">
					<div class="flex">
						<img src="img2/speaker (1).png" alt="" style="margin-left: 8px;">
						<p>공지사항</p>
					</div>
				</div>
			</div>
		</div>

		<div class="banner">
			<div class="swiper mySwiper">
				<div class="swiper-wrapper flex">
					<div class="swiper-slide">
						<img src="img/slideBanner.png" alt="">
					</div>
					<div class="swiper-slide">
						<img src="img/slideBanner2.png" alt="">
					</div>
					<div class="swiper-slide">
						<img src="img/slideBanner3.png" alt="">
					</div>
					<div class="swiper-slide">
						<img src="img/slideBanner4.png" alt="">
					</div>
				</div>
			</div>
		</div>
		<div class="bottomLine"></div>

		<div id="footer-container">
			<footer class='footer'>
				<p class="text">
					(주)피움 | 대표이사 김나연 | 주소 : 서울특별시 강남구 테헤란로 7길 7 <br> 전화 1234-5678
					| E-mail : pieum@naver.com | 고객센터 5678-1234 <br> © PIEUM Korea
					Corporation All Rights Reserved.
				</p>
			</footer>
		</div>
	</div>
</body>
</html>