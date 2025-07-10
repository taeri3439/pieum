
function searchPw(event) {

   event.preventDefault();
   var mname = document.getElementById("mname").value.trim();
   var phone = document.getElementById("phone").value.trim();
   var mid = document.getElementById("mid").value.trim();

   if (!mname || !phone || !mid) {
      alert("이름과 전화번호를 모두 입력하세요.");
      return;
   }

   fetch("http://localhost:8080/TeamProject1/pwSearchForm.user", {
      method: "POST",
      headers: {
         "Content-Type": "application/x-www-form-urlencoded"
      },
      body: `mname=${encodeURIComponent(mname)}&phone=${encodeURIComponent(phone)}&mid=${encodeURIComponent(mid)}`
   })
      .then(response => response.text())
      .then(data => {
         
         console.log("서버 응답:", data);
         
         let [status, message] = data.split("|");
         if (status === "success") {
            alert("비밀번호: " + message);

         } else {
            alert(message);
         }
      })
      .catch(error => {
         console.error("오류 발생:", error);
         alert("오류가 발생했습니다. 다시 시도해주세요.");
      });
      
      return false; // 폼이 서버로 바로 제출되지 않도록 막음
}