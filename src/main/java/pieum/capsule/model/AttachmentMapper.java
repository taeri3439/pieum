package pieum.capsule.model;

public interface AttachmentMapper {

	// 첨부파일 추가
	public int insertAttachment(AttachmentDTO attachment);

	// 첨부파일 수정
	public int updateAttachment(AttachmentDTO attachment);

	// 첨부파일 삭제
	public int deleteAttachment(String fno);

	// 특정 게시글의 모든 첨부파일 삭제
	public int deleteAttachmentsByBno(String bno);
}
