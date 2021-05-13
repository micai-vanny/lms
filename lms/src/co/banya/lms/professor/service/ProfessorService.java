package co.banya.lms.professor.service;

import java.util.List;

import co.banya.lms.professor.vo.ProfessorVO;
import co.banya.lms.student.vo.StudentVO;

public interface ProfessorService {
	List<ProfessorVO> professorSelectAll(); 
	ProfessorVO professorSelect(ProfessorVO vo);
	int professorInsert(ProfessorVO vo);
	int professorUpdate(ProfessorVO vo);
	int professorDelete(ProfessorVO vo);
	
	String idCheck(String id);
	ProfessorVO loginCheck(ProfessorVO vo);
	ProfessorVO login(ProfessorVO vo);
}
