package pieum.capsule.mapper;

import java.util.List;

import pieum.capsule.model.InquiryDTO;

public interface InquiryMapper {

	 // 공지/문의 등록
    public int insertInquiry(InquiryDTO notice);
    
    // 공지/문의 상세 조회
    public InquiryDTO selectNoticeDetail(String nno);
    
    // 공지/문의 수정
    public int updateNotice(InquiryDTO notice);
    
    // 답변 등록/수정
    public int updateAnswer(InquiryDTO notice);
    
    // 공지/문의 삭제
    public int deleteNotice(String nno);
    
    // 특정 사용자의 1:1 문의 목록 조회
    public List<InquiryDTO> selectMyInquiryList(String userId);
    
    // 답변 대기 중인 문의 목록 조회
    public List<InquiryDTO> selectPendingInquiries();
    
    // 공지/문의 개수 조회
    public int selectNoticeTotalCount(); 
}
