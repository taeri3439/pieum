package pieum.user.mapper;

import java.util.List;

import pieum.user.model.LikeDTO;

public interface LikeMapper {

	  // 좋아요 추가
    public int insertLike(LikeDTO like);
    
    // 좋아요 삭제
    public int deleteLike(String lno);

    
}
