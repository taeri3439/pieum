<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <meta name="viewport" content="width=400, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Document</title>

    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    
    
    <jsp:include page = "include/link.html" />
	<script src="js/mypage.js" defer></script>
    <link rel="stylesheet" href="css/mypage.css">
    
</head>
<body>
<div class='wrap'>
    <jsp:include page="include/header.jsp" />
    
	<div id="contents">

        <div class="mypage">
            <div class="titleWrap">
                <h5>내 정보</h5>
            </div>

            <section class="myinfoWrap">
                <div class="myinfo">
                    <div class="myPhoto">
                        <img src="img/profile.jpg" alt="">
                    </div>
                    <div class="myinfoDetail">
                        <p class="myname">${userDTO.mname}</p>
                        <span>
                            <span class="mygender">
                            	<c:if test="${userDTO.gender=='M'}">
									남
								</c:if>
									
								<c:if test="${userDTO.gender=='F'}">
									여
								</c:if>
                            </span>
                            <span class="">|</span>
                            <span class="myage" data-age="${userDTO.birth}">
                            ${userDTO.birth}세
                            </span>
                        </span>
                    </div>
                </div>
                <div class="myinfoBtn">
                    <div class="btnWrap">
                        <span><a href="modifyInfo.user" class='modifyLink'>수정하기</a></span>
                        <span>|</span>
                        <span><a href="#" class='inquiryLink'>1:1 문의하기</a></span>
                    </div>
                <%--     <c:choose>
					<c:when test="${sessionScope.userDTO != null }">
						<a href="logout.user" style="font-size:10px;">로그아웃</a>
					</c:when>
				</c:choose> --%>
				<div class="reg_content"><a href="delete.user" onclick="return confirm('정말 탈퇴하시겠습니까?');" style="color:red;">회원탈퇴</a></div>
                </div>
            </section>
            
            <div class="titleWrap">
                <h5>내가 속한 그룹</h5>
                <p><a href="#" class='mygroupLink'>더보기 ></a></p>
            </div>
            <section class="mygroups">
                <div class="group">
                     <div class="groupinfo">
                        <div class="groupCreator">
                            <img src="img/profile.jpg" alt="#">
                            <p>rivermoon___</p>
                            
                        </div>
                        <div class="groupDate">24.09.08 ~ 24.09.19</div>
                     </div>

                     <div class="groupmember">
                        <span><img src="img/profile.jpg" alt="#" class="member1"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member2"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member3"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member4"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member5"></span>
                     </div>
                     <div class="grouptag">
                        <p>#활발</p>
                        <p>#여름</p>
                        <p>#카페</p>
                        <p>#맑음</p>
                     </div>
                </div>
                <div class="group">
                     <div class="groupinfo">
                        <div class="groupCreator">
                            <img src="img/profile.jpg" alt="#">
                            <p>rivermoon___</p>
                        </div>
                        <div class="groupDate">24.09.08 ~ 24.09.19</div>
                     </div>

                     <div class="groupmember">
                        <span><img src="img/profile.jpg" alt="#" class="member1"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member2"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member3"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member4"></span>
                        <span><img src="img/profile.jpg" alt="#" class="member5"></span>
                     </div>
                     <div class="grouptag">
                        <p>#활발</p>
                        <p>#여름</p>
                        <p>#카페</p>
                        <p>#맑음</p>
                     </div>
                </div>
            </section>

            <div class="titleWrap">
                <h5>나의 타임 캡슐</h5>
                <p><a href="#" class='myCapsuleLink'>더보기 ></a></p>
            </div>
            <section class="mycapsule">
                <div class="capsule">
                    <img src="img/banner.jpg" alt="">
                    <div class="capsuleinfo">
                        <p class="title">제목</p>
                        <p class="timer">
                            <span>남은시간</span>
                            <span class="time">00:00:00</span>
                        </p>
                    </div>
                </div>
                <div class="capsule">
                    <img src="img/banner.jpg" alt="">
                    <div class="capsuleinfo">
                        <p class="title">제목</p>
                        <p class="timer">
                            <span>남은시간</span>
                            <span class="time">00:00:00</span>
                        </p>
                    </div>
                </div>
            </section>

            <div class="notices">
                <a href="#" class='myinquiryLink'>내 문의내역</a>
                <div class="spacing"></div>
                <a href="#" class='inquiryLink'>1:1 문의하기</a>
            </div>

        </div>
    </div>
    <jsp:include page="include/footer.html" />
   </div>
</body>

</html>
