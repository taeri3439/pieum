package pieum.capsule.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TimeCapsuleMapper {


	   // 타임캡슐 추가 (삽입)
    int insertTimeCapsule(TimeCapsuleDTO timeCapsule);

    // 특정 타임캡슐 조회 (tcno로 조회)
    TimeCapsuleDTO getTimeCapsuleByTcno(String tcno);

    // 모든 타임캡슐 조회
    List<TimeCapsuleDTO> getAllTimeCapsules();

    // 타임캡슐 삭제 (tcno로 삭제)
    int deleteTimeCapsule(String tcno);
	
}
