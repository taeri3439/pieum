<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<jsp:include page="include/link.html" />
<script src="js/viewCapsule.js" defer></script>
<link rel="stylesheet" href="css/viewCapsule.css">
</head>
<body>
	<div class='watchWrap'>
		<jsp:include page="include/header.jsp" />
		
		
		<c:set var="bgStyle" value="background-image: url('img/backgorund.jpg')" />
		<c:if test="${not empty capsuleDTO.files}">
			<c:set var="bgStyle" value="background-image: url('image?fno=${capsuleDTO.files[0].fno}');" />
		</c:if>
		
		<div id="watchContents" style="${bgStyle}">
			<!-- <img src="img/backgorund.jpg" alt=""> -->
			<div class="heart">
				<span><img src="img/pink_icon_heart.png" alt="pinkHeart"></span>
				<span>10</span>
			</div>

			<div class="title">
 				<p>
 				<c:if test="${empty capsuleDTO }">
					title
				</c:if>
				<c:if test="${not empty capsuleDTO }">
					${capsuleDTO.tcTitle }
				</c:if>
				</p>
			</div>
			<div class="titleSlide">
				<div class="swiper mySwiper4">
					<div class="swiper-wrapper">
						<c:if test="${!empty capsuleDTO.files }">
							<c:forEach var="image" items="${capsuleDTO.files}">
								<div class="swiper-slide">
									<img src="image?fno=${image.fno}" alt="swiperImages">
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${empty capsuleDTO.files }">
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
							<div class="swiper-slide">
								<img src="img/backgorund.jpg" alt="swiperImages">
							</div>
						</c:if>
					</div>
					<div class="swiper-pagination"></div>
				</div>
			</div>
			<div class="title_bottom_content">
				<p>
				<c:if test="${empty capsuleDTO }">
					나는 이번 주제에 대해 곰곰이 생각해 보았다. 요즘 나의 최대 걱정. 솔직하게 써야 할지 고민했다. 이 글은
					많은 사람들이 볼 수 있는 글이다. 그러니 주제는 바이러스에 관한 걱정 등 대중적인 걱정일 법한 것으로 선택하려 했다.
					하지만 나의 이야기를 담지 않은 글은 진정한 나의 글이 아니라는 생각이 들어, 나의 진실된 나는 이번 주제에 대해 곰곰이
					생각해 보았다. 요즘 나의 최대 걱정. 솔직하게 써야 할지 고민했다. 이 글은 많은 사람들이 볼 수 있는 글이다. 그러니
					주제는 바이러스에 관한 걱정 등 대중적인 걱정일 법한 것으로 선택하려 했다. 하지만 나의 이야기를 담지 않은 글은 진정한
					나의 글이 아니라는 생각이 들어, 나의 진실된
				</c:if>
				<c:if test="${not empty capsuleDTO }">
					${capsuleDTO.tcContent }
				</c:if>
				
					
					</p>
				<span>더보기 ...</span>
			</div>
			<div class="chat">
				<ul>
					<li>
						<figure>
							<img src="img/ex.jpg" alt="chatProfile">
						</figure>
						<div class="chat_info">
							<h6>강유진</h6>
							<p>안녕하세요~~!!^ㅅ^</p>
							<span class="reply">답장하기</span> <span>지우기</span>
						</div>
						<div class="chat-heart">
							<span><img src="img/pink_icon_heart.png" alt="pinkHeart"></span>
							<span>10</span>
						</div>
					</li>
					<li>
						<figure>
							<img src="img/ex.jpg" alt="chatProfile">
						</figure>
						<div class="chat_info">
							<h6>송유경</h6>
							<p>안녕하세요~~!!^ㅅ^</p>
							<span class="reply">답장하기</span> <span>지우기</span>
						</div>
						<div class="chat-heart">
							<span><img src="img/pink_icon_heart.png" alt="pinkHeart"></span>
							<span>10</span>
						</div>
					</li>
					<li>
						<figure>
							<img src="img/ex.jpg" alt="chatProfile">
						</figure>
						<div class="chat_info">
							<h6>김대영</h6>
							<p>안녕하세요~~!!^ㅅ^</p>
							<span class="reply">답장하기</span> <span>지우기</span>
						</div>
						<div class="chat-heart">
							<span><img src="img/pink_icon_heart.png" alt="pinkHeart"></span>
							<span>10</span>
						</div>
					</li>
					<li>
						<figure>
							<img src="img/ex.jpg" alt="chatProfile">
						</figure>
						<div class="chat_info">
							<h6>김현수</h6>
							<p>안녕하세요~~!!^ㅅ^</p>
							<span class="reply">답장하기</span> <span>지우기</span>
						</div>
						<div class="chat-heart">
							<span><img src="img/pink_icon_heart.png" alt="pinkHeart"></span>
							<span>10</span>
						</div>
					</li>
					<li>
						<figure>
							<img src="img/ex.jpg" alt="chatProfile">
						</figure>
						<div class="chat_info">
							<h6>송택호</h6>
							<p>안녕하세요~~!!^ㅅ^</p>
							<span class="reply">답장하기</span> <span>지우기</span>
						</div>
						<div class="chat-heart">
							<span><img src="img/pink_icon_heart.png" alt="pinkHeart"></span>
							<span>10</span>
						</div>
					</li>
					<li>
						<figure>
							<img src="img/ex.jpg" alt="chatProfile">
						</figure>
						<div class="chat_info">
							<h6>김나연</h6>
							<p>안녕하세요~~!!^ㅅ^ 안녕하세요~~!!^ㅅ^ 안녕하세요~~!!^ㅅ^ 안녕하세요~~!!^ㅅ^</p>
							<span class="reply">답장하기</span> <span>지우기</span>
						</div>
						<div class="chat-heart">
							<span><img src="img/pink_icon_heart.png" alt="pinkHeart"></span>
							<span>10</span>
						</div>
					</li>
				</ul>
			</div>
			<div class="comment">
				<figure>
					<img src="img/ex.jpg" alt="commentImg">
				</figure>
				<div class="input-wrapper">
					<input type="text" name="comment" placeholder="댓글을 입력하세요">
					<button type="button" class="upload">
						<img src="img/upArrow.png" alt="업로드">
					</button>
				</div>
			</div>

		</div>

	</div>
</body>
</html>