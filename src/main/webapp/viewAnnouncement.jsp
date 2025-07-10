<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<jsp:include page="include/link.html" />
<link rel="stylesheet" href="css/viewAnnouncement.css">
<script src="js/viewAnnouncement.js" defer></script>
</head>
<body>
	<div class='wrap'>
		<jsp:include page="include/header.jsp" />

		<div id="contents">
			<div class="viewAnnounce">
				<p class="title">공지사항</p>
	
				<div class="write">
					<form action="#">
						<p class="subtitle">${announcement.ntitle}</p>
						<div class="line">
							
						</div>

						
						<div class="line">
							<textarea name="content" id="content" maxlength="1000" readonly>${announcement.ncontent}</textarea>
						</div>
					</form>

					<div class="line submit">
						<button type="button" class="homeBtn" onclick="location.href='home.jsp'">홈으로</button>
						<button type="button" class="submitBtn" onclick="location.href='announcement.inquiry'">목록</button>
					</div>
				</div>
			</div>
			<jsp:include page="include/footer.html" />
		</div>
	</div>
</body>
</html>