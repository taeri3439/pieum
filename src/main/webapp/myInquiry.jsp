<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/myInquiry.css">
</head>
<body>
	<div class='wrap'>
	    <jsp:include page="include/header.jsp" />   
	    
	    <div id="contents">
	    	<div class='myInquiry'>
		    	<h3>문의 내역</h3>
		    	<c:forEach var="inquiry" items="${inquiries}">
			        <div class="card">
			            <div class="first">
			                <p class="date">
								<fmt:formatDate value="${inquiry.nregdate}" pattern="yyyy년 MM월 dd일" />
							</p>
			            </div>
			            <div class="second">
			                <a class="title">${inquiry.ntitle}</a>
	    					<c:choose>
	  						  <c:when test="${empty inquiry.acontent}">
	      						  <span style="color: red;">답변 대기중</span>
	    					  </c:when>
	    					  <c:otherwise>
	       						  <span style="color: green;">답변 완료</span>
	    					  </c:otherwise>
							</c:choose>
			            </div>
			            <div class="third">
							<button class="bbtn" onclick="location.href='detail.inquiry?nno=${inquiry.nno}'">상세보기</button>
			            </div>
			        </div>
		        </c:forEach>
	        </div>
	    </div>
	    
	    <jsp:include page="include/footer.html"/>
	</div>
</body>
</html>