package pieum.capsule.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pieum.capsule.model.InquiryDTO;
import pieum.capsule.model.InquiryMapper;
import pieum.user.model.UserDTO;
import pieum.util.mybatis.MyBatisUtil;

public class InquiryServiceImpl implements InquiryService{
	
	private SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

	@Override
	public void insertInquiry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    SqlSession sql = sqlSessionFactory.openSession(true);
	    HttpSession session = request.getSession();
	    try {
	    	UserDTO userDto = (UserDTO)session.getAttribute("userDTO");
	    	
	    	String mno = userDto.getMno();
	        String title = request.getParameter("ntitle");
	        String content = request.getParameter("ncontent");
	        String type = request.getParameter("ntype");
	        
	        System.out.println("title:" + title);
	        System.out.println("content:" + content);
	        System.out.println("type:" + type);
	        

	        // 파라미터 검증
	        if (mno == null || mno.isEmpty()) {
	           
	            if (mno == null || mno.isEmpty()) {
	                throw new RuntimeException("회원 번호(mno)가 누락되었습니다.");
	            }
	        }

	        if (title == null || title.isEmpty() || content == null || content.isEmpty() || type == null || type.isEmpty()) {
	            throw new RuntimeException("필수 입력값이 누락되었습니다.");
	        }

	        // DTO 객체 생성 및 값 설정
	        InquiryDTO dto = new InquiryDTO();
	        dto.setMno(mno);
	        dto.setNtitle(title);
	        dto.setNcontent(content);
	        dto.setNtype(type);
	        

	        // Mapper를 통해 데이터베이스에 저장
	        InquiryMapper inquiryMapper = sql.getMapper(InquiryMapper.class);
	        int result = inquiryMapper.insertInquiry(dto);

	        // 결과 처리
	        if (result > 0) {
	            System.out.println("DB 저장 성공");
	            response.sendRedirect("myInquiry.inquiry");
	        } else {
	            System.out.println("DB 저장 실패");
	            request.setAttribute("error", "문의 등록에 실패했습니다.");
	            request.getRequestDispatcher("/inquiry.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        sql.close();
	    }
	}



	
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	@Override
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}




	@Override
	public List<InquiryDTO> getInquiriesByMno(String mno) {
		SqlSession sql = sqlSessionFactory.openSession();
        try {
            InquiryMapper mapper = sql.getMapper(InquiryMapper.class);
            return mapper.selectInquiriesByMno(mno);
        } finally {
            sql.close();
        }
	}




	@Override
	public InquiryDTO getInquiryDetail(String nno) {
		SqlSession sql = sqlSessionFactory.openSession();
        try {
            InquiryMapper mapper = sql.getMapper(InquiryMapper.class);
            return mapper.selectNoticeDetail(nno);
        } finally {
            sql.close();
        }
	}
	
	@Override
	public List<InquiryDTO> getAnnouncementList() {
	    SqlSession sql = sqlSessionFactory.openSession();
	    try {
	        InquiryMapper mapper = sql.getMapper(InquiryMapper.class);
	        return mapper.selectAnnouncementList();
	    } finally {
	        sql.close();
	    }
	}
	
	@Override
	public InquiryDTO getAnnouncementDetail(String nno) {
	    SqlSession sql = sqlSessionFactory.openSession();
	    try {
	        InquiryMapper mapper = sql.getMapper(InquiryMapper.class);
	        return mapper.getAnnouncementDetail(nno);
	    } finally {
	        sql.close();
	    }
	}

}
