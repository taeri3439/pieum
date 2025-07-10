package pieum.user.model;

import java.util.List;

public interface GroupMapper {

	  // 그룹 생성
    public int insertGroup(GroupDTO group);
    
    // 그룹 상세 조회
    public GroupDTO selectGroupDetail(String gno);
    
    // 그룹 삭제
    public int deleteGroup(String gno);
    
    // 전체 그룹 목록 조회
    public List<GroupDTO> selectGroupList();
    
    // 특정 사용자가 속한 그룹 목록 조회
    public List<GroupDTO> selectUserGroupList(String userId);
    
    // 그룹 검색
    public List<GroupDTO> searchGroups(String keyword);
    
    // 그룹 총 개수 조회
    public int selectGroupTotalCount();
}
