package pieum.user.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pieum.user.model.UserDTO;

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
    
    // pw변경
    int updatePassword(Map<String, String> pwMap);

    // 사용자 삭제
    int deleteUser(String mno);
	
}
