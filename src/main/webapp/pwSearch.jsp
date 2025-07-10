<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<jsp:include page="include/link.html" />

<link rel="stylesheet" href="css/idSearch.css">
<script src="js/pwSearch.js" defer></script>


</head>
<body>
   <div class='wrap'>
      <jsp:include page="include/header.jsp" />

      <div id="contents">
      <h5>비밀번호 찾기</h5>
         <form method="post" action="pwSearch.user"  onsubmit="return searchPw(event);">
            <div style="margin-bottom:15px;">
               <label for="mname"></label> <input type="text" id="mid"
                  name="mname" placeholder="아이디" required>
            </div>
            <div style="margin-bottom:15px;">
               <label for="mname"></label> <input type="text" id="mname"
                  name="mname" placeholder="이름" required>
            </div>
            <div>
               <label for="phone"></label> <input type="text" id="phone"
                  name="phone" placeholder="전화번호" required>
            </div>
            <button type="submit">비밀번호 찾기</button>
         </form>
      </div>
      <!-- contents영역종료 -->

      <jsp:include page="include/footer.html" />

   </div>
</body>
</html>