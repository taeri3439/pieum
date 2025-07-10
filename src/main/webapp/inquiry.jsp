<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/inquiry.css">
</head>
<body>
    <div class='wrap'>
        <jsp:include page="include/header.jsp" />   
        
        <div id="contents">
            <div class='inquiry'>
                <p class='main-text'>문의하기</p>
                <form action="save.inquiry" method="post">
                	 <select name="ntype">
        				<option value="문의">문의</option>
       					<option value="공지">공지</option>
   					 </select>
                    <div class="background">
                        <p class="inquiry-title">문의제목</p>
                        <div class="title-box"> 
                            <input type="text" class="title" name="ntitle" required>
                        </div>
                        <p class="inquiry-detail">문의내용</p>
                        <div class="detail-box">
                            <textarea class="detail" name="ncontent" required></textarea>
                        </div>
                         <input type="hidden" name="mno" value="${sessionScope.mno}">
                        <button type="submit" class="bbtn">작성완료</button>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="include/footer.html"/>
    </div>
</body>
</html>
