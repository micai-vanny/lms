package co.banya.lms.enrolment.service;

import java.util.List;

import co.banya.lms.enrolment.vo.EnrolmentVO;

public interface EnrolmentService {
	List<EnrolmentVO> EnrolmentSelectAll();
	EnrolmentVO EnrolmentSelect(EnrolmentVO vo);
	int EnrolmentInsert(EnrolmentVO vo);
	int EnrolmentUpdate(EnrolmentVO vo);
	int EnrolmentDelete(EnrolmentVO vo);
}
