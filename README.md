# 🎁 TeamProject1 - 타임캡슐 기반 JSP 웹 프로젝트

**TeamProject1**은 사용자 간 타임캡슐을 작성하고 공유할 수 있는 JSP 기반의 어플리케이션입니다.  
사용자는 타임캡슐 생성, 그룹 관리, 공지사항, 문의 및 회원 기능 등을 사용할 수 있습니다.

---

## ✨ 주요 기능

- 📨 타임캡슐 작성, 조회, 수정
- 👨‍👧‍👦 그룹 생성 및 관리
- 📢 공지사항 확인
- 🔐 로그인 / 회원가입 / 마이페이지
- 📋 문의 작성 및 확인

---

## 🧑‍💻 나의 역할

- **로그인 / 회원가입 기능 구현**
  - 사용자의 입력값 유효성 검사 (아이디 중복 확인, 패스워드 일치 등)
  - 로그인 실패 시 에러 메시지 처리 및 세션 저장

- **접근 제어 필터 구현 (인증 체크)**
  - 로그인하지 않은 사용자가 특정 JSP 페이지에 접근 시, 로그인 페이지로 리다이렉트
  - `Filter`를 활용해 인증 상태를 검사하고, `session` 기반 접근 제어 적용

- **세션 처리 및 로그아웃 기능 구현**
  - 로그인 시 세션에 사용자 정보 저장, 로그아웃 시 세션 초기화 처리

- **마이페이지 정보 출력 연동**
  - 로그인된 사용자 정보를 기반으로 마이페이지에서 이름, 이메일 등 출력

---

## 🛠 사용 기술

- Java 8
- JSP / Servlet
- JSTL / EL
- MyBatis
- Tomcat
- HTML / CSS / JS

---
## 🖥️ 실행 화면

<div style="display: flex; gap: 20px; align-items: flex-start;">

  <div>
    <strong>메인 페이지</strong><br>
    <img src="https://private-user-images.githubusercontent.com/219836557/466457704-c0d86340-672e-4206-8484-7ac79e777038.png" alt="피움메인화면" width="400">
  </div>

  <div>
    <strong>글보기 페이지</strong><br>
    <img src="https://private-user-images.githubusercontent.com/219836557/466458301-136a50fb-ddf4-4c4e-8092-a161661f3dbe.png" alt="글보기페이지" width="400">
  </div>

</div>

---

## 📁 폴더 구조

```bash
TeamProject1/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pieum/
│   │   │       ├── capsule/
│   │   │       │   ├── mapper/             # 캡슐 관련 MyBatis Mapper 인터페이스
│   │   │       │   ├── model/              # 캡슐 VO 클래스
│   │   │       │   └── service/            # 캡슐 비즈니스 로직
│   │   │       ├── controller/             # 서블릿 및 JSP 연결 컨트롤러
│   │   │       ├── user/
│   │   │       │   ├── mapper/             # 사용자 관련 Mapper
│   │   │       │   ├── model/              # 사용자 VO 클래스
│   │   │       │   └── service/            # 사용자 비즈니스 로직
│   │   │       ├── util/                   # 유틸리티 클래스
│   │   │       └── pieum.util.mybatis/     # MyBatis 설정 관련 유틸
│   │   └── resources/
│   │       └── mybatis/
│   │           ├── config/                 # MyBatis 설정 파일 (예: config.xml)
│   │           └── mapper/                 # XML 기반 SQL 매퍼들
├── webapp/
│   ├── css/                                
│   ├── html/                               
│   ├── img/                                
│   ├── img2/                               
│   ├── include/                            # 공통 include (헤더, 푸터 등)
│   ├── js/                                 
│   ├── META-INF/
│   ├── WEB-INF/                            
│   ├── anouncement.jsp                    
│   ├── capsuleList.jsp                     
│   ├── groupdetails.jsp                   
│   ├── home.jsp                            
│   ├── idSearch.jsp                       
│   ├── index.jsp                           
│   ├── inquiry.jsp                         
│   ├── inquiryDetail.jsp                   
│   ├── login.jsp                           
│   ├── modifyInfo.jsp                      
│   ├── mygroup.jsp                         
│   ├── myInquiry.jsp                       
│   ├── mypage.jsp                          
│   ├── pwSearch.jsp                        
│   ├── signup.jsp                         
│   ├── viewAnnouncement.jsp                
│   ├── viewCapsule.jsp                     
│   └── writeCapsule.jsp                    
├── JSP 프로젝트1차DB.txt                  
├── TeamProject1.iml
```
---

### 😮 프로젝트를 통해 느낀 점

처음으로 사용자 인증 기능을 직접 구현하며 웹 애플리케이션의 흐름을 구체적으로 이해할 수 있었습니다.  
단순한 화면 구현을 넘어 세션과 필터를 활용해 접근 제어를 적용하면서 **"로그인된 사용자만 특정 기능에 접근 가능하도록 제어하는 방법"**을 실무처럼 경험할 수 있었습니다.

또한, 팀원들과 역할을 나누고 소통하며 협업의 중요성을 체감했고,  
Git을 활용한 형상 관리와 JSP, MyBatis 연동 과정에서도 많은 시행착오를 겪으며 문제를 해결하는 힘을 키울 수 있었습니다.

이번 프로젝트를 통해 웹의 기본 구조와 동작 원리에 대한 감을 잡았고, 실제 서비스처럼 작동하는 프로그램을 직접 만들며 개발자로서의 자신감도 얻게 되었습니다.

