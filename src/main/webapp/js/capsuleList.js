var btn = document.querySelector('.writeCapsuleBtn');
var capsuleBox = document.querySelector('.capsuleBox');

btn.onclick=function(){
	window.location.href='writeForm.capsule';
}

capsuleBox.onclick=function(){
	//alert(event.target.closest('.capsule'));
	var capsule = event.target.closest('.capsule');
	
	if (!capsule) return;
	if (capsule.querySelector('.capsuleLock')) return;
	
	var tcno = capsule.getAttribute('data-tcno');
	if (!tcno) window.location.href = "view.capsule";
	else window.location.href = "view.capsule?tcno=" + encodeURIComponent(tcno);
	


}

setInterval(function () {
    var countdowns = document.querySelectorAll(".timeAmount");

    countdowns.forEach(elem => {
        var openDateStr = elem.getAttribute("data-opendate"); // 또는 elem.dataset.opendate
        var openDate = new Date(openDateStr);
        var now = new Date();

        var diff = openDate - now;

        if (diff <= 0) {
            elem.innerHTML = "오픈";
            return;
        }

        var totalSeconds = Math.floor(diff / 1000);
        var days = Math.floor(totalSeconds / (3600 * 24));
        var hours = Math.floor((totalSeconds % (3600 * 24)) / 3600);
        var minutes = Math.floor((totalSeconds % 3600) / 60);
        var seconds = totalSeconds % 60;

        elem.innerHTML =
            `${days}일 ` +
            `${String(hours).padStart(2, '0')}시간 ` +
            `${String(minutes).padStart(2, '0')}분 ` +
            `${String(seconds).padStart(2, '0')}초`;
    });
}, 1000);