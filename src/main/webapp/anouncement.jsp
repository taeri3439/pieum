<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/anouncement.css">
    <script src="js/anouncement.js" defer></script>
</head>
<body>
	<div class='wrap'>
	    <jsp:include page="include/header.jsp" />   
	    
	    <div id="contents">
	    	<div class='anouncement'>
		    	<p class='main-text'>공지사항</p>
		    	<div class="background">
		    	
		    	
			        <div class="cardbox">
			          <ul id="notice-list">
					    <c:forEach var="announcement" items="${announcements}">
					        <li>
					            <div class="card" data-nno="${announcement.nno}" onclick="location.href='viewAnnouncement.inquiry?nno=${announcement.nno}'">
					                <p class="title">${announcement.ntitle}</p>
					                <span class="date">${announcement.nregdate}</span>
					            </div>
					        </li>
					    </c:forEach>
					</ul>

			            <div id="pagination"></div>
			        </div>
			    </div>
		    </div>
	   	</div>
	    
	    <jsp:include page="include/footer.html"/>
	</div>
</body>
</html>