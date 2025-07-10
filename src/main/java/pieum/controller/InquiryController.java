package pieum.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pieum.capsule.model.InquiryDTO;
import pieum.capsule.service.InquiryService;
import pieum.capsule.service.InquiryServiceImpl;
import pieum.user.model.UserDTO;

@WebServlet("*.inquiry")
public class InquiryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String command = uri.substring(conPath.length());

        InquiryService service = new InquiryServiceImpl();
        if(command.equals("/write.inquiry")) {
        	HttpSession session = request.getSession();
            UserDTO userDto = (UserDTO)session.getAttribute("userDTO");
            
            if (userDto == null) {
                // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/login.user");
                return;
            }
            
            response.sendRedirect("inquiry.jsp");
        }
        else if (command.equals("/save.inquiry")) {
        	HttpSession session = request.getSession();
            UserDTO userDto = (UserDTO)session.getAttribute("userDTO");
            
            if (userDto == null) {
                // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/login.user");
                return;
            }
            
            System.out.println("요청 처리 시작: /save.inquiry");
            service.insertInquiry(request, response);
            System.out.println("요청 처리 완료: /save.inquiry");
        }else if (command.equals("/myInquiry.inquiry")) {
            // 세션에서 사용자 정보 가져오기
            HttpSession session = request.getSession();
            UserDTO userDto = (UserDTO)session.getAttribute("userDTO");
            
            if (userDto == null) {
                // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/login.user");
                return;
            }
            
            // 사용자의 mno 가져오기
            String mno = userDto.getMno();
            
            // 사용자의 문의내역 조회
            List<InquiryDTO> inquiries = service.getInquiriesByMno(mno);
            System.out.println(inquiries.toString());
            // 결과를 request에 저장
            request.setAttribute("inquiries", inquiries);
            
            // 문의내역 페이지로 포워드
            request.getRequestDispatcher("/myInquiry.jsp").forward(request, response);
        } else if (command.equals("/detail.inquiry")) {
        	System.out.println(1111111);
            // 요청에서 nno 파라미터 가져오기
            String nno = request.getParameter("nno");
            
            System.out.println("상세보기"+nno);
            
            // nno로 문의 상세 정보 조회
            InquiryDTO inquiry = service.getInquiryDetail(nno);
            
            System.out.println(inquiry.toString());
            // 결과를 request에 저장
            request.setAttribute("inquiry", inquiry);
            
            // 상세 페이지로 포워드
            request.getRequestDispatcher("/inquiryDetail.jsp").forward(request, response);
            
        }else if (command.equals("/announcement.inquiry")) {
        	System.out.println("목록조회 컨트롤러");
            // 공지사항 목록 조회
            List<InquiryDTO> announcements = service.getAnnouncementList();
            System.out.println("📢 announcements size: " + (announcements != null ? announcements.size() : "null"));
            
            // 결과를 request에 저장
            request.setAttribute("announcements", announcements);

            // anouncement.jsp로 포워드
            request.getRequestDispatcher("/anouncement.jsp").forward(request, response);
        
        } else if (command.equals("/viewAnnouncement.inquiry")) {
            // 요청에서 nno 파라미터 가져오기
            String nno = request.getParameter("nno");

            // nno로 공지사항 상세 정보 조회
            InquiryDTO announcement = service.getAnnouncementDetail(nno);

            // 결과를 request에 저장
            request.setAttribute("announcement", announcement);

            // viewAnnouncement.jsp로 포워드
            request.getRequestDispatcher("/viewAnnouncement.jsp").forward(request, response);
        }
    }

    
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        if(command.equals("/inquiry.jsp.inquiry")) {
//        	request.getRequestDispatcher("inquiry.jsp").forward(request, response);
//        } else if(command.equals("/myInquiry.jsp.inquiry")) {
//        	
//        	String title = request.getParameter("ntitle");
//        	String content = request.getParameter("ncontent");
//        	String type = request.getParameter("ntype");
//        	
//        	InquiryDTO InquiryDTO = new InquiryDTO();
//        	InquiryDTO.setNtitle(title);
//        	InquiryDTO.setNncontent(content);
//        	InquiryDTO.setNtype(type);
//        	
//        	HttpSession session = request.getSession();
//        	String mno = (String) session.getAttribute("mno");
//        	InquiryDTO.setMno(mno);
//
//        	service.insertInquiry(request, response);
//        	
//        	request.getRequestDispatcher("myInquiry.jsp").forward(request, response);
//        }
        
       
        
        
        
        
        
        
//        
//            // 기존 코드 유지
//            
//        } else if(command.equals("/save.inquiry")) {
//            // 폼에서 제출된 데이터 가져오기
//            String title = request.getParameter("title");
//            String content = request.getParameter("detail");
//            
//            // 로그 출력
//            System.out.println("제목: " + title);
//            System.out.println("내용: " + content);
//            
//            // DTO 객체 생성 및 값 설정
//            InquiryDTO inquiryDTO = new InquiryDTO();
//            inquiryDTO.setNtitle(title);
//            inquiryDTO.setNncontent(content);
//            
//            // 현재 시간 설정
//            Timestamp currentTime = new Timestamp(new Date().getTime());
//            inquiryDTO.setNregdate(currentTime);
//            
//            // 세션에서 사용자 ID 가져오기 (로그인 기능이 있다면)
//            // HttpSession session = request.getSession();
//            // String userId = (String) session.getAttribute("userId");
//            // inquiryDTO.setUserId(userId); // DTO에 해당 필드가 있다면
//            
//            // 서비스를 통해 데이터베이스에 저장
//            int result = service.write(inquiryDTO);
//            
//            if(result > 0) {
//                // 저장 성공 시 리다이렉트할 페이지 (예: 문의 목록 페이지)
//                response.sendRedirect(request.getContextPath() + "/inquiryList.inquiry");
//            } else {
//                // 저장 실패 시
//                request.setAttribute("errorMessage", "문의 등록에 실패했습니다.");
//                request.getRequestDispatcher("inquiry.jsp").forward(request, response);
//            }
//        } else if(command.equals("/inquiryList.inquiry")) {
//            // 문의 목록 페이지로 이동하는 코드 (필요하다면 구현)
//            request.getRequestDispatcher("inquiryList.jsp").forward(request, response);
//        }


