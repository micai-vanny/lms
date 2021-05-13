package co.banya.lms.course.service;

import java.util.List;

import co.banya.lms.course.vo.CourseVO;

public interface CourseService {
	List<CourseVO> CourseSelectAll();
	CourseVO CourseSelect(CourseVO vo);
	int CourseInsert(CourseVO vo);
	int CourseUpdate(CourseVO vo);
	int CourseDelete(CourseVO vo);
}
