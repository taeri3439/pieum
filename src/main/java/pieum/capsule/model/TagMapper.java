package pieum.capsule.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TagMapper {


	 // XML 매퍼를 통해 SQL을 호출하도록 정의된 메서드
    // 새로운 태그를 데이터베이스에 삽입하는 기능을 수행합니다.
    int insertTag(TagDTO tag);

    // tno를 이용하여 특정 태그를 조회하는 메서드
    // 주어진 tno에 해당하는 태그를 반환합니다.
    TagDTO getTagByTno(String tno);

    // 모든 태그를 조회하는 메서드
    // 데이터베이스에 있는 모든 태그를 리스트로 반환합니다.
    List<TagDTO> getAllTags();

    // 태그 정보를 업데이트하는 메서드
    // 주어진 TagDTO 객체의 정보를 기반으로 태그를 업데이트합니다.
    int updateTag(TagDTO tag);

    // tno를 이용하여 태그를 삭제하는 메서드
    // 주어진 tno에 해당하는 태그를 삭제합니다.
    int deleteTag(String tno);
	
}
