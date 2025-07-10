package pieum.capsule.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pieum.capsule.model.InquiryDTO;

public interface InquiryService {
	
/* 작성 */	void insertInquiry(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
/* 삭제 */	void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
/* 수정 */	void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
/* 내 문의 조회 */ List<InquiryDTO> getInquiriesByMno(String mno);
/* 문의 상세 조회 */ InquiryDTO getInquiryDetail(String nno);
			List<InquiryDTO> getAnnouncementList();
			InquiryDTO getAnnouncementDetail(String nno);

}
