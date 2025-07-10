<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<meta name="viewport"
	content="width=400, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Document</title>



<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<jsp:include page="include/link.html" />

<link rel="stylesheet" href="css/capsuleList.css">
<script src="js/capsuleList.js" defer></script>

</head>
<body>
	<div class='wrap'>
		<jsp:include page="include/header.jsp" />

		<div id="contents">
			<div class="capsuleList">
				<div class="filterLine">
					<p>게시물보기</p>
					<select id='filter' name="tags">
						<c:forEach var="tag" items="${tags}" varStatus="var">
							<option value="${tag.tno }">${tag.tName }</option>
						</c:forEach>
					</select>
				</div>

				<div class="capsuleBox">
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
	
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>
					<div class="capsuleWrap">
						<div class="capsule">
							<div class="capsuleInfo">
								<div class="titleWrap">
									<span>"</span> <span class="title">오늘은 냥줍 한 날</span> <span>"</span>
								</div>
								<div class="tagList">
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
									<div class="tag">
										<span># 맑음</span>
									</div>
								</div>
								<div class="contents">
									<p>오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고 오늘은 어쩌고
									</p>
								</div>
							</div>

						</div>
					</div>

					<c:forEach var="capsule" items="${capsuleList}">
						<div class="capsuleWrap">

							<c:set var="bgStyle" value="background-image: url('img/1.jpg')" />
							<c:if test="${not empty capsule.files}">
								<c:set var="bgStyle" value="background-image: url('image?fno=${capsule.files[0].fno}');" />
							</c:if>
							<div class="capsule" style="${bgStyle}" data-tcno="${capsule.tcno}">
								<c:if test="${capsule.opened}">
									<div class="capsuleInfo">
										<div class="titleWrap">
											<span>"</span> <span class="title">${capsule.tcTitle}</span>
											<span>"</span>
										</div>

										<div class="tagList">
											<c:forEach var="tag" items="${capsule.tags}">
												<div class="tag">
													<span>${tag.tName}</span>
												</div>
											</c:forEach>
										</div>
										<div class="contents">
											<p>${capsule.tcContent }</p>
										</div>
									</div>
								</c:if>
								<c:if test="${not capsule.opened}">
									<div class="capsuleLock">
										<div class="restTime">
											<p>「 남은 시간 」</p>
											<p class="timeAmount" data-opendate="${capsule.openDate}"></p>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</c:forEach>





				</div>
			</div>
		</div>
		<!-- contents부분 -->
		<jsp:include page="include/footer.html" />
		<div class="writeCapsuleBtn">
			<img src="img2/writeCapsule.png">
		</div>
	</div>
	<!-- wrap부분 -->
</body>

</html>
