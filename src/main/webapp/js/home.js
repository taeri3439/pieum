var username = sessionStorage.getItem("userId");
var beforeLogingo = document.querySelector(".beforeLogin");
var login = document.querySelector(".login");
var beforeLoginMemory = document.querySelector(".beforeLogin-memory");
var memoryList = document.querySelector(".memoryList");
var myPageLink = document.querySelector('.homepage .myPageLink');
var beforeLogin = document.querySelector(".beforeLogin h3");
var announcement = document.querySelector(".announcement .swiper-slide");
var group = document.querySelector(".CapsuleReveal .swiper-slide");
var topViews = document.querySelector(".topViews .viewBox");

(function(){
    var ageSpan = document.querySelector(".genderAndage .age");
    if (!ageSpan) return;

    var birthStr = ageSpan.getAttribute("data-age");  // 예: 2025-03-27
    if (!birthStr) return;

    var birthDate = new Date(birthStr);
    var today = new Date();

    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();

    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }

    // 출력: 생일 (yyyy-MM-dd) + 나이
    ageSpan.textContent = `${age}세`;
})();


/* swiper */
var swiper2 = new Swiper(".mySwiper2", {
    direction: "vertical",
    loop: true,
    speed: 1000,
    slidesPerView: 1,
    autoplay: {
        delay: 2500,
        disableOnInteraction: false,

    },
});

var swiper3 = new Swiper(".mySwiper3", {
    slidesPerView: 2,
    spaceBetween: 20,
    loop: true,
    speed: 1000,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    autoplay: {
        delay: 3500,
        disableOnInteraction: false,

    },
});



/*  내정보 */
if(beforeLogingo!=null){
	beforeLogingo.addEventListener('click', function () {
	    window.location.href = 'login.user';
	})
}
if(myPageLink!=null){
	myPageLink.onclick=function(){
		event.preventDefault();
		window.location.href="mypage.user";
	}
}


/* 공지사항 */
announcement.addEventListener('click', function () {
    window.location.href = 'viewAnnouncement.jsp';
})


/*타임캡슐*/
group.addEventListener('click', function () {
    window.location.href = 'viewCapsule.jsp';
})

/*Top조회수*/
topViews.addEventListener('click', function () {
    window.location.href = 'viewCapsule.jsp';
})



/* 로그인 여부 확인*/

/*if (username) {
    console.log("로그인된 사용자: " + username);
    // 로그인 상태일 때
    beforeLogingo.style.display = "none";
    login.style.display = "flex";
    
    // 추억 섹션도 처리
    beforeLoginMemory.style.display = "none";
    memoryList.style.display = "block";
} else {
    console.log("로그인 정보가 없습니다");
    // 로그인 상태가 아닐 때
    beforeLogingo.style.display = "block";
    login.style.display = "none";
    
    // 추억 섹션도 처리
    beforeLoginMemory.style.display = "flex";
    memoryList.style.display = "none";
}
*/