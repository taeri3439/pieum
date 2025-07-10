package pieum.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserMappingTableMapper {


	 // 사용자와 그룹의 맵핑 추가
    int insertUserGroupMapping(UserMapingTableDTO userMaping);

    // 특정 사용자가 속한 모든 그룹 조회
    List<UserMapingTableDTO> getAllGroupsByUser(String mno);

    // 특정 그룹에 속한 모든 사용자 조회
    List<UserMapingTableDTO> getAllUsersByGroup(String gno);

    // 사용자 그룹 맵핑 상태 변경 (승인 또는 탈퇴)
    int updateUserGroupStatus(UserMapingTableDTO userMaping);

    // 사용자 그룹 맵핑 삭제
    int deleteUserGroupMapping(String mno, String gno);
	
}
