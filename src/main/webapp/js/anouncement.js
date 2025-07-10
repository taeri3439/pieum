document.addEventListener('DOMContentLoaded', function () {
    const anounceList = document.querySelector('.anouncement .cardbox');

    // 공지사항 카드 클릭 이벤트
    anounceList.addEventListener('click', function (event) {
        const card = event.target.closest('.card');
        if (card) {
            const nno = card.getAttribute('data-nno'); // 공지 번호 가져오기
            window.location.href = `viewAnnouncement.inquiry?nno=${nno}`; // 상세보기 페이지로 이동
        }
    });
});

$(document).ready(function () {
    const itemsPerPage = 5; // 한 페이지에 표시할 공지사항 개수
    const $items = $("#notice-list li"); // 공지사항 리스트
    const totalPages = Math.ceil($items.length / itemsPerPage); // 총 페이지 수
    let currentPage = 1;

    function showPage(page) {
        const start = (page - 1) * itemsPerPage;
        const end = start + itemsPerPage;
        $items.hide().slice(start, end).show(); // 지정된 범위의 항목만 표시
    }

    function createPaginationButtons() {
        const $pagination = $("#pagination");
        $pagination.html("");

        // 이전 버튼 추가
        if (currentPage > 5) {
            $pagination.append(`<button id="prev-btn" class="nav-btn">이전</button>`);
        }

        // 페이지 번호 버튼 추가
        for (let i = 1; i <= totalPages; i++) {
            $pagination.append(`<button class="page-btn ${currentPage === i ? 'active' : ''}">${i}</button>`);
        }

        // 다음 버튼 추가
        if (currentPage < totalPages && totalPages>5) {
            $pagination.append(`<button id="next-btn" class="nav-btn">다음</button>`);
        }

        $(".page-btn").on("click", function () {
            currentPage = parseInt($(this).text());
            showPage(currentPage);
            createPaginationButtons();
        });

        $("#prev-btn").on("click", function () {
            if (currentPage > 1) {
                currentPage--;
                showPage(currentPage);
                createPaginationButtons();
            }
        });

        $("#next-btn").on("click", function () {
            if (currentPage < totalPages) {
                currentPage++;
                showPage(currentPage);
                createPaginationButtons();
            }
        });
    }

    // 초기화 시 함수 호출
    showPage(currentPage);
    createPaginationButtons();
});




/*var anounceList = document.querySelector('.anouncement .cardbox');


anounceList.onclick=function(){
	//alert(event.target.closest('.card'));
	
	window.location.href='viewAnnouncement.jsp';
}


$(document).ready(function () {
    const itemsPerPage = 5; // 한 페이지에 표시할 공지사항 개수
    const $items = $("#notice-list li"); // 공지사항 리스트
    const totalPages = Math.ceil($items.length / itemsPerPage); // 총 페이지 수
    let currentPage = 1;

    function showPage(page) {
        const start = (page - 1) * itemsPerPage;
        const end = start + itemsPerPage;
        $items.hide().slice(start, end).show(); // 지정된 범위의 항목만 표시
    }

    function createPaginationButtons() {
        const $pagination = $("#pagination");
        $pagination.html("");

        // 이전 버튼 추가
        if (currentPage > 1) {
            $pagination.append(`<button id="prev-btn" class="nav-btn">이전</button>`);
        }

        // 페이지 번호 버튼 추가
        for (let i = 1; i <= totalPages; i++) {
            $pagination.append(`<button class="page-btn ${currentPage === i ? 'active' : ''}">${i}</button>`);
        }

        // 다음 버튼 추가
        if (currentPage < totalPages) {
            $pagination.append(`<button id="next-btn" class="nav-btn">다음</button>`);
        }

        $(".page-btn").on("click", function () {
            currentPage = parseInt($(this).text());
            showPage(currentPage);
            createPaginationButtons();
        });

        $("#prev-btn").on("click", function () {
            if (currentPage > 1) {
                currentPage--;
                showPage(currentPage);
                createPaginationButtons();
            }
        });

        $("#next-btn").on("click", function () {
            if (currentPage < totalPages) {
                currentPage++;
                showPage(currentPage);
                createPaginationButtons();
            }
        });
    }

    // 초기화 시 함수 호출
    showPage(currentPage);
    createPaginationButtons();
});


$(document).ready(function () {
    const itemsPerPage = 5; // 한 페이지에 표시할 공지사항 개수
    const $items = $("#notice-list li"); // 공지사항 리스트
    const totalPages = Math.ceil($items.length / itemsPerPage); // 총 페이지 수
    let currentPage = 1;

    function showPage(page) {
        const start = (page - 1) * itemsPerPage;
        const end = start + itemsPerPage;
        $items.hide().slice(start, end).show();
    }

    function createPaginationButtons() {
        const $pagination = $("#pagination");
        $pagination.html("");

        // 이전 버튼 추가 (자리 유지)
        $pagination.append(
            `<button id="prev-btn" class="nav-btn ${currentPage === 1 ? 'disabled' : ''}">이전</button>`
        );

        // 첫 번째 페이지 항상 표시
        $pagination.append(`<button class="page-btn ${currentPage === 1 ? 'active' : ''}">1</button>`);

        // 중간 페이지 처리
        if (currentPage > 3) {
            $pagination.append(`<span class="ellipsis">...</span>`);
        }

        // 현재 페이지 기준 앞뒤 2개씩 표시
        for (let i = Math.max(2, currentPage - 1); i <= Math.min(totalPages - 1, currentPage + 1); i++) {
            $pagination.append(`<button class="page-btn ${currentPage === i ? 'active' : ''}">${i}</button>`);
        }

        // 마지막 페이지 처리
        if (currentPage < totalPages - 2) {
            $pagination.append(`<span class="ellipsis">...</span>`);
        }
        
        if (totalPages > 1) {
            $pagination.append(`<button class="page-btn ${currentPage === totalPages ? 'active' : ''}">${totalPages}</button>`);
        }

        // 다음 버튼 추가 (자리 유지)
        $pagination.append(
            `<button id="next-btn" class="nav-btn ${currentPage === totalPages ? 'disabled' : ''}">다음</button>`
        );

        // 페이지 번호 클릭 이벤트 추가
        $(".page-btn").on("click", function () {
            currentPage = parseInt($(this).text());
            showPage(currentPage);
            createPaginationButtons();
        });

        // 이전 버튼 클릭 이벤트 추가
        $("#prev-btn").on("click", function () {
            if (currentPage > 1) {
                currentPage--;
                showPage(currentPage);
                createPaginationButtons();
            }
        });

        // 다음 버튼 클릭 이벤트 추가
        $("#next-btn").on("click", function () {
            if (currentPage < totalPages) {
                currentPage++;
                showPage(currentPage);
                createPaginationButtons();
            }
        });
    }

    // 초기화 시 함수 호출
    showPage(currentPage);
    createPaginationButtons();
});

*/