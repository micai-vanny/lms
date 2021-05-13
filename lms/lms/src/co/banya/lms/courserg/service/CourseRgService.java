package co.banya.lms.courserg.service;

import java.util.List;

import co.banya.lms.courserg.vo.CourseRgVO;

public interface CourseRgService {

	List<CourseRgVO> courseRgSelectAll();
	CourseRgVO courseRgSelect(CourseRgVO vo);
	int courseRgInsert(CourseRgVO vo);
	int courseRgUpdate(CourseRgVO vo);
	int courseRgDelete(CourseRgVO vo);
	
	CourseRgVO preCourseId(CourseRgVO vo);
}
