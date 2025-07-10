package pieum.capsule.service;

import java.util.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pieum.capsule.mapper.TagMapper;
import pieum.capsule.mapper.TimeCapsuleMapper;
import pieum.capsule.model.FileDTO;
import pieum.capsule.model.TagDTO;
import pieum.capsule.model.TimeCapsuleDTO;
import pieum.util.mybatis.MyBatisUtil;

public class CapsuleServiceImpl implements CapsuleService {
	// sqlSessionFactory 객체 생성
	private SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

	@Override
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String openDateStr = request.getParameter("openDate");
		LocalDate localDate = LocalDate.parse(openDateStr); // 자동 형식 체크됨

		Timestamp openDate = Timestamp.valueOf(localDate.atStartOfDay()); // "2025-03-23 00:00:00"
		String[] tags = request.getParameterValues("tags"); // 태그 체크박스 값 받아오기 (체크된 태그들만 배열로 받음)


		SqlSession sql = sqlSessionFactory.openSession(true);
		TimeCapsuleMapper capsuleMapper = sql.getMapper(TimeCapsuleMapper.class);

		// 캡슐 아이디 받아오기		
		String tcno = capsuleMapper.getCapsuleId();

		System.out.println("캡슐아이디 받아오기");
		// 캡슐 저장
		TimeCapsuleDTO capsule = new TimeCapsuleDTO();
		capsule.setTcno(tcno);
		capsule.setGno("100"); // 그룹번호 설정 필요
		capsule.setMno("U12"); // 회원번호 설정 필요
		capsule.setOpenDate(openDate);
		//		capsule.setPrivates(0);
		capsule.setTcContent(content);
		capsule.setTcTitle(title);

		capsuleMapper.insertCapsule(capsule);
		System.out.println("캡슐저장");

		System.out.println(Arrays.toString(tags));
		// 태그 업로드
		if (tags != null) {
			for (String tag : tags) {
				System.out.println("태그 처리 시작: tag = [" + tag + "]");
				Map<String,String> map = new HashMap<>();
				map.put("tno", tag);
				map.put("tcno", tcno);

				try {
					int result = capsuleMapper.insertTag(map);
					System.out.println("✅ 태그 매핑 성공: " + tag + " (" + result + " row)");
					System.out.flush();
				} catch (Exception e) {
					System.out.println("❌ 태그 매핑 실패: " + tag);
					e.printStackTrace(); // << 이게 반드시 찍혀야 함!
					System.out.flush();
				}
			}
		}
		System.out.println("태그 업로드");

		// 파일 처리 (예: Multipart)
		Collection<Part> parts = request.getParts();

		for (Part part : parts) {
			// 파일 필드 이름이 "file"일 때만 처리
			if (part.getName().equals("file") && part.getSize() > 0) {
				String submittedFileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

				// InputStream으로 파일 내용을 읽음
				byte[] fileData = part.getInputStream().readAllBytes();

				// FileDTO 생성 후 저장
				FileDTO fileDTO = new FileDTO();
				fileDTO.setFileName(submittedFileName);
				fileDTO.setFileData(fileData);
				fileDTO.setTcno(tcno);  // 캡슐 번호 설정

				capsuleMapper.insertFile(fileDTO);
			}
		}
		System.out.println("파일 업로드");
		response.sendRedirect("list.capsule");
	}







	@Override
	public void selectCapsulesByGno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sql = sqlSessionFactory.openSession(true);
		TimeCapsuleMapper mapper = sql.getMapper(TimeCapsuleMapper.class);
		
		String gno = "100"; // gno 설정 
		List<TimeCapsuleDTO> capsuleList = mapper.selectCapsulesByGno(gno);
		System.out.println(capsuleList.toString());

		// 각 캡슐에 대해 파일 목록을 불러와서 넣기
		for (TimeCapsuleDTO capsule : capsuleList) {
			String tcno = capsule.getTcno();
			List<FileDTO> files = mapper.selectFileByTcno(tcno);
			capsule.setFiles(files); // TimeCapsuleDTO에 List<FileDTO> files 필드 필요
		}
		
		// 태그넣기
		for (TimeCapsuleDTO capsule : capsuleList) {
			String tcno = capsule.getTcno();
			List<TagDTO> tagList = mapper.selectTagByTcno(tcno);
			System.out.println(tagList.toString());
			
			capsule.setTags(tagList); // TimeCapsuleDTO에 List<FileDTO> files 필드 필요
		}
		
		// 오픈 여부 넣기
		LocalDateTime now = LocalDateTime.now();

		for (TimeCapsuleDTO capsule : capsuleList) {
		    capsule.setOpened(capsule.getOpenDate().toLocalDateTime().isBefore(now)
		        || capsule.getOpenDate().toLocalDateTime().isEqual(now));
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("capsuleList", capsuleList);
		
		
		TagMapper tagMapper = sql.getMapper(TagMapper.class);
		List<TagDTO> list = tagMapper.getAllTags();
		session.setAttribute("tags",list);
		response.sendRedirect("viewList.capsule");
	}







	@Override
	public void getTags(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		TagMapper mapper = sql.getMapper(TagMapper.class);
		
		List<TagDTO> list = mapper.getAllTags();
		session.setAttribute("tags",list);
		response.sendRedirect("writeCapsule.jsp");
		
		
	}







	@Override
	public void selectCapsuleByTcno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tcno = request.getParameter("tcno");
		
		HttpSession session = request.getSession();
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		TimeCapsuleMapper mapper = sql.getMapper(TimeCapsuleMapper.class);
		
		if(tcno!=null) {
			TimeCapsuleDTO dto = mapper.selectCapsuleByTcno(tcno);
			List<FileDTO> capsuleFile = mapper.selectFileByTcno(tcno);
			
			dto.setFiles(capsuleFile);
			session.setAttribute("capsuleDTO", dto);
		}
		else {
			session.setAttribute("capsuleDTO", null);
		}
		try {
	        request.getRequestDispatcher("viewCapsule.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	

}
