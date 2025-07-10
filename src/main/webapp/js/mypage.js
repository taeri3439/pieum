var myInquiryLink = document.querySelector('.mypage .myinquiryLink');
var inquiryLink = document.querySelectorAll('.mypage .inquiryLink');
var modifyLilnk = document.querySelector('.mypage .modifyLink');
var mygroupLink = document.querySelector('.mypage .mygroupLink');
var myCapsuleLink = document.querySelector('.mypage .myCapsuleLink');
/*var logoutLink = document.querySelector('.mypage .logoutLink');*/
var mygroups = document.querySelector('.mypage .mygroups');
var mycapsule = document.querySelector('.mypage .mycapsule');


(function(){
    var ageSpan = document.querySelector(".mypage .myage");
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

/* 단순 페이지 이동 링크*/
myInquiryLink.onclick=function(){
	event.preventDefault();
	window.location.href='myInquiry.inquiry';
}

inquiryLink.forEach(link => {
    link.onclick = function(event) {
        event.preventDefault(); // 기본 동작 방지
        window.location.href = 'write.inquiry'; // 페이지 이동
    };
});

modifyLilnk.onclick=function(){
	event.preventDefault();
	window.location.href='modifyInfo.jsp';
}

mygroupLink.onclick=function(){
	event.preventDefault();
	window.location.href='mygroup.jsp';
}

myCapsuleLink.onclick=function(){
	event.preventDefault();
	window.location.href='capsuleList.jsp';
}

/*logoutLink.onclick=function(){
	event.preventDefault();
	
	window.location.href='home.jsp';
}*/


/* 컨텐츠,그룹 클릭시 상세보기  */
mygroups.onclick=function(){
	console.log(event.target.closest('.group'))
	window.location.href='groupdetails.jsp';
}

mycapsule.onclick=function(){
	console.log(event.target.closest('.capsule'))
	window.location.href='viewCapsule.jsp';
}