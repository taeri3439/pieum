package pieum.user.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pieum.user.model.UserDTO;
import pieum.user.model.UserMapper;
import pieum.util.mybatis.MyBatisUtil;

public class UserServiceImpl implements UserService{
	// sqlSessionFactory 객체 생성
	private SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userType = request.getParameter("userType");
		String name = request.getParameter("userName");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		String email  = request.getParameter("email");
		String domain  = request.getParameter("domain");
		if(domain!=null) email+="@"+domain;
		String phone = request.getParameter("phone");

		System.out.println(userType);

		// 마이바티스 영역  = DAO를 대신함
		SqlSession sql = sqlSessionFactory.openSession(true);
		UserMapper user = sql.getMapper(UserMapper.class);
		UserDTO dto = new UserDTO(userType,id,pw,name,gender,birth,phone,email);
		int result=0;
		
		
		if(userType.equals("A")) result= user.registAdmin(dto);
		else if(userType.equals("U")) result = user.registUser(dto);
		
		System.out.println(111);
		sql.close();
		// System.out.println(result);
		response.sendRedirect("home.jsp");
		
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");

		System.out.println(mid);
		System.out.println(mpw);

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("mid", mid.trim());
		paramMap.put("mpw", mpw.trim());

		SqlSession sql = sqlSessionFactory.openSession(true);
		UserMapper mapper = sql.getMapper(UserMapper.class);
		UserDTO dto = mapper.loginUser(paramMap);
		sql.close();

		if (dto == null) {
			System.out.println("없어");
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 비밀번호를 확인하세요.');");
			out.println("location.href='login.user'");
			out.println("</script>");

		} else {
			System.out.println("있어");
			HttpSession session = request.getSession();
			session.setAttribute("userDTO", dto);
			response.sendRedirect("home.user");
		}
		

	}

	@Override
	public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mpw = request.getParameter("newmpw");

		
		if (mid == null || mpw == null || mname == null) {
			response.getWriter().write("필수 입력값이 없습니다.");
			return;
		}

		UserDTO user = new UserDTO();

		user.setMid(mid);
		user.setMpw(mpw);
		user.setMname(mname);

		SqlSession sql = sqlSessionFactory.openSession(true);
		UserMapper mapper = sql.getMapper(UserMapper.class);

		int result = mapper.updateUser(user);
		sql.close();

		if (result == 1) {
			System.out.println("성공.");
			HttpSession session = request.getSession();
			UserDTO dto = (UserDTO) session.getAttribute("userDTO");
			String birth = dto.getBirth();
			String gender = dto.getGender();
			
			//기존 세션에 있던 birth와 gender 값을 새 user 객체에 설정
			user.setBirth(birth);
			user.setGender(gender);
			session.setAttribute("userDTO", user);
			response.sendRedirect("mypage.user");
		} else {
			System.out.println("실패.");
		}

	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

	    if (userDTO == null) {
	        response.sendRedirect("login.user");
	        return;
	    }


	    String mid = userDTO.getMid();  // 회원 번호 가져오기

	    SqlSession sql = sqlSessionFactory.openSession(true);
	    UserMapper mapper = sql.getMapper(UserMapper.class);
	    int result = mapper.deleteUser(mid);
	    sql.close();

	    if (result == 1) {
	        session.invalidate(); // 회원 삭제 성공 시 세션 무효화
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('회원 탈퇴가 완료되었습니다.');");
	        out.println("location.href='home.user';");
	        out.println("</script>");
	    } else {
	        response.sendRedirect("mypage.user"); // 실패 시 마이페이지로 이동
	    }

	}


	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 세션 가져오기
	    HttpSession session = request.getSession(false); // 기존 세션 가져오기 (없으면 null 반환)

	    if (session != null) {
	        session.invalidate(); // 세션 무효화 (로그아웃)
	    }

	    // 로그아웃 메시지와 함께 로그인 페이지로 이동
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<script>");
	    out.println("alert('로그아웃 되었습니다.');");
	    out.println("location.href='" + request.getContextPath() + "/login.user';");
	    out.println("</script>");
		
	}

	@Override
	public void userCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		Map<String, String> checkMap = new HashMap<>();
		checkMap.put("mid", mid);
		checkMap.put("mpw", mpw);

		SqlSession sql = sqlSessionFactory.openSession(true);
		UserMapper mapper = sql.getMapper(UserMapper.class);
		String result = mapper.getPasswordById(checkMap);
		
		sql.close();
		
	    // 응답 설정 - 브라우저에게 받을 데이터가 어떤 형태인지 알려줌
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");

	    // 단순 텍스트 응답
	    PrintWriter out = response.getWriter();
	    out.print(result);
	    out.flush();
		
	}
	
	@Override
	   public void idSearch(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {

	      String mname = request.getParameter("mname");
	      String phone = request.getParameter("phone");

	      /*
	       * if (mname == null || phone == null) {
	       * response.setContentType("text/plain; charset=UTF-8"); PrintWriter out =
	       * response.getWriter(); out.print("fail|이름과 전화번호를 입력하세요."); out.flush();
	       * return; }
	       */
	      SqlSession sql = sqlSessionFactory.openSession(true);
	      UserMapper mapper = sql.getMapper(UserMapper.class);

	      Map<String, String> paramMap = new HashMap<>();
	      paramMap.put("mname", mname.trim());
	      paramMap.put("phone", phone.trim());

	      String userId = mapper.findUserId(paramMap);
	      sql.close();

	      
	      response.setContentType("text/plain");
	      response.setCharacterEncoding("UTF-8");
	      PrintWriter out = response.getWriter();
	      if(userId == null) {
	          out.print("fail|입력하신 정보로 아이디를 찾을 수 없습니다.");
	      } else {
	          out.print("success|" + userId);
	      }
	      out.flush();
	   }
	


	   @Override
	   public void pwSearch(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {

	      String mid = request.getParameter("mid");
	      String mname = request.getParameter("mname");
	      String phone = request.getParameter("phone");

	      /*
	       * if (mname == null || phone == null) {
	       * response.setContentType("text/plain; charset=UTF-8"); PrintWriter out =
	       * response.getWriter(); out.print("fail|이름과 전화번호를 입력하세요."); out.flush();
	       * return; }
	       */
	      SqlSession sql = sqlSessionFactory.openSession(true);
	      UserMapper mapper = sql.getMapper(UserMapper.class);

	      Map<String, String> paramMap = new HashMap<>();
	      paramMap.put("mname", mname.trim());
	      paramMap.put("phone", phone.trim());
	      paramMap.put("mid", mid.trim());

	      String userPw = mapper.findUserPw(paramMap);
	      System.out.println(userPw);
	      sql.close();

	      
	      response.setContentType("text/plain");
	      response.setCharacterEncoding("UTF-8");
	      PrintWriter out = response.getWriter();
	      if(userPw == null) {
	          out.print("fail|입력하신 정보로 비밀번호를 찾을 수 없습니다.");
	      } else {
	          out.print("success|" + userPw);
	      }
	      out.flush();
	   }


}
