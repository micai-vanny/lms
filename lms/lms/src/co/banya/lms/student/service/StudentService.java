package co.banya.lms.student.service;

import java.util.List;

import co.banya.lms.student.vo.StudentVO;

// 관례적으로 인터페이스에는 service라는 이름을 사용한다.
// 테이블 마다 각각 인터페이스 만들어 줌.

public interface StudentService {
				   // 같은 패키지 안(co.banay.lms.student)에 있기 때문에
	List<StudentVO> studentSelectAll();	// 현업에서는 이런 형태로 씀니다.
	StudentVO studentSelect(StudentVO vo);
	StudentVO ErolmentSelect(StudentVO vo);
	int studentInsert(StudentVO vo);
	int studentUpdate(StudentVO vo);
	int studentDelete(StudentVO vo);
	int courseRegist(StudentVO vo);
	void entryCount(String courseId);
	
	String idCheck(String studentId);
	StudentVO loginCheck(StudentVO vo);
	StudentVO login(StudentVO vo);
}
