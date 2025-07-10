package pieum.capsule.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pieum.capsule.model.FileDTO;
import pieum.capsule.model.TagDTO;
import pieum.capsule.model.TimeCapsuleDTO;

public interface TimeCapsuleMapper {


	// 타임캡슐 번호(작성시) 얻기 -- 태그, 파일 업로드시 필요
	String getCapsuleId();
	String getTagId(String tname);
	// 타임캡슐 추가 (삽입)
	void insertCapsule(TimeCapsuleDTO timeCapsule);
	
	int insertTag(Map<String,String> map);

	void insertFile(FileDTO fileDTO);
	
	FileDTO selectFileById(String fno);
	List<TimeCapsuleDTO> selectCapsulesByGno(String gno);
	List<FileDTO> selectFileByTcno(String tcno);
	List<TagDTO> selectTagByTcno(String tno);
	
    // 특정 타임캡슐 조회 (tcno로 조회)
    TimeCapsuleDTO selectCapsuleByTcno(String tcno);

    // 모든 타임캡슐 조회
    List<TimeCapsuleDTO> getAllTimeCapsules();

    // 타임캡슐 삭제 (tcno로 삭제)
    int deleteTimeCapsule(String tcno);
	
	
}
