# 🎁 TeamProject1 - 타임캡슐 기반 JSP 웹 프로젝트

**TeamProject1**은 사용자 간 타임캡슐을 작성하고 공유할 수 있는 JSP 기반의 웹 어플리케이션입니다.  
사용자는 타임캡슐 생성, 그룹 관리, 공지사항, 문의 및 회원 기능 등을 사용할 수 있습니다.

---

## ✨ 주요 기능

- 📨 타임캡슐 작성, 조회, 수정
- 👨‍👧‍👦 그룹 생성 및 관리
- 📢 공지사항 확인
- 🔐 로그인 / 회원가입 / 마이페이지
- 📋 문의 작성 및 확인

---

## 🛠 사용 기술

- Java 8
- JSP / Servlet
- JSTL / EL
- MyBatis
- Tomcat
- HTML / CSS / JS

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
