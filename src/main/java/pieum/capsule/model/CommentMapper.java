package pieum.capsule.model;

import java.util.List;

public interface CommentMapper {
	
	  public int insertComment(CommentDTO comment);
	    
	    // 댓글 상세 조회
	    public CommentDTO selectCommentDetail(String cno);
	    
	    // 댓글 수정
	    public int updateComment(CommentDTO comment);
	    
	    // 댓글 삭제
	    public int deleteComment(String cno);
	    
	    // 댓글 목록 조회 (특정 게시글에 대한)
	    public List<CommentDTO> selectCommentList(String bno);
	    
	    // 댓글 개수 조회
	    public int selectCommentTotalCount(String bno);

}
