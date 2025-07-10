<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 상세</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/inquiryDetail.css">
    <style>
    
    .inquiry  .answer-box {
	text-align: center;
}

.inquiry  .answer {
	width: 98%;
	resize: none;
	border-radius: 6px;
	height: 100px;
	padding: 5px;
	border: 1px solid rgb(179, 179, 179);
}



.inquiry .answer-title {
	margin-top: 20px;
}
    
    </style>
    
</head>
<body>
    <div class='wrap'>
        <jsp:include page="include/header.jsp" />   
        
        <div id="contents">
            <div class='inquiry'>
                <p class='main-text'>문의 상세보기</p>
                
                	
                    <div class="background">
                     <p class="inquiry-title">문의제목</p>
                        
                        <div class="title-box"> 
                             <input type="text" class="title" value="${inquiry.ntitle}" readonly>
                        </div>
                        <p class="inquiry-detail">문의내용</p>
                        <div class="detail-box">
                            <textarea class="detail" readonly>${inquiry.ncontent}</textarea>
                        </div>
						<c:if test="${not empty inquiry.acontent}">
                		
                   			<p class="answer-title" >답변</p>
                   			<div class="answer-box">
                            <textarea class="answer" placeholder="답변 대기중" readonly >${inquiry.acontent}</textarea>
                       		</div>
           		 		</c:if>                        
                        
                         <input type="hidden" name="mno" value="${sessionScope.mno}">
                        <button class="bbtn" onclick="location.href='myInquiry.inquiry'">목록으로</button>
                    </div>
            </div>
        </div>
        <jsp:include page="include/footer.html"/>
    </div>
</body>
</html>
