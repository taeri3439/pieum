<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <meta name="viewport" content="width=400, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Document</title>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<jsp:include page = "include/link.html" />
   
    <link rel="stylesheet" href="css/writeCapsule.css">
    <script src="js/writeCapsule.js" defer></script>
    
</head>
<body>
<div class='wrap'>
    <jsp:include page="include/header.jsp" />

    <div id="contents">
        <div class="write">
            <form action="write.capsule" method="post" name="capsuleForm" enctype="multipart/form-data">
                <div class="line"><input type="text" id='title' name="title" placeholder="제목"></div>
                <div class="line"><textarea name="content" id="content" maxlength="1000" placeholder="내용을 적으세요."></textarea></div>
                <p class="context">추억 담기</p>
                <div class="line timeWrap">
                    <input type="date" id='openDate' name='openDate' required>
                </div>
                
                <p class="context">태그</p>
                <div class="tagList">
	                <c:forEach var="tag" items="${tags}" varStatus="status">
	                    <div class="tag">
	                        <input type="checkbox" name="tags" id="tag${status.count}" value="${tag.tno}">
	                        <label for="tag${status.count}" class="radio-btn">${tag.tName }</label>
	                    </div>
	                </c:forEach>
                </div>
                <p class="context">추억 담기</p>
                <div class="line preViewWrap">
                    <input type="file" id="file" name='file' accept="image/*" multiple>
                    <div class="preView">
                        <label for="file" class="fileUpload fileBox">+</label>
                    </div>
                </div>
                <div class="line submit">
                    <button type="submit" class="submitBtn">작성하기</button>
                </div>
            </form>
        </div>
	    <jsp:include page="include/footer.html" />
    </div>
</div>

</body>

</html>
