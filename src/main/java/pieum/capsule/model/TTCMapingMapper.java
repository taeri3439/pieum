package pieum.capsule.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TTCMapingMapper {


	// 태그와 타임캡슐 맵핑 추가
    int insertTTCMaping(TTCMapingDTO ttcMaping);

    // 특정 태그와 타임캡슐 맵핑 조회
    TTCMapingDTO getTTCMaping(String tno, String tcno);

    // 특정 태그에 관련된 모든 타임캡슐 조회
    List<TTCMapingDTO> getAllTimeCapsulesByTag(String tno);

    // 특정 타임캡슐에 관련된 모든 태그 조회
    List<TTCMapingDTO> getAllTagsByTimeCapsule(String tcno);

    // 태그와 타임캡슐 맵핑 삭제
    int deleteTTCMaping(String tno, String tcno);
	
}
