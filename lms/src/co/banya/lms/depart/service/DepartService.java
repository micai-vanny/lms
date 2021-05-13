package co.banya.lms.depart.service;

import java.util.List;

import co.banya.lms.depart.vo.DepartVO;

public interface DepartService {
	List<DepartVO> departSelectAll();
	DepartVO departSelect(DepartVO vo);
	int departInsert(DepartVO vo);
	int departUpdate(DepartVO vo);
	int departDelete(DepartVO vo);
}
