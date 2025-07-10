package pieum.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserMapper {


	// 사용자 추가 (회원 가입)
    int registUser(UserDTO user);
    int registAdmin(UserDTO user);

    // 모든 사용자 조회
    List<UserDTO> getAllUsers();
    
    // 특정 사용자 조회 (mno로 조회)
    UserDTO getUserByMno(String mno);

    // 사용자 로그인 정보 확인 (mid와 mpw로 조회)
    UserDTO loginUser(Map<String, String> paramMap);

    // pw확인
    String getPasswordById(String mid);

    // 사용자 정보 수정
    int updateUser(UserDTO user);
    
    // pw확인
    String getPasswordById(Map<String, String> checkMap);
    
    // 사용자 삭제
    int deleteUser(String mid);
	
    
    // 아이디찾기
    String findUserId(Map<String, String> paramMap);
    
    // 비밀번호찾기
    String findUserPw(Map<String, String> paramMap);
}
