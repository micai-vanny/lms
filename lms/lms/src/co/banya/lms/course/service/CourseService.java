package co.banya.lms.course.service;

import java.util.List;

import co.banya.lms.course.vo.CourseVO;

public interface CourseService {
	List<CourseVO> courseSelectAll();
	CourseVO courseSelect(CourseVO vo);
	int courseInsert(CourseVO vo);
	int courseUpdate(CourseVO vo);
	int courseDelete(CourseVO vo);
	
	String entryCount(String courseId);	// 수강가능 인원 감소
	String entryCheck(String courseId);	// 현재 수강 가능 인원 체크
	String entryRestore(String courseId);	// 수강 취소 시 인원 다시 증가
}
