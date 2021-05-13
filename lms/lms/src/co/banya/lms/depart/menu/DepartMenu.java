package co.banya.lms.depart.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.banya.lms.common.*;
import co.banya.lms.depart.service.DepartService;
import co.banya.lms.depart.serviceImpl.DepartServiceImpl;
import co.banya.lms.depart.vo.DepartVO;

public class DepartMenu implements ScInputOutput {
	
	private DepartService ds = new DepartServiceImpl();
	DepartVO vo;
	
	private void MenuTitle() {
		System.out.println("=======메   뉴=======");
		System.out.println("== 1. 전체 학과 조회 ==");
		System.out.println("== 2. 학과     검색 ==");
		System.out.println("== 3. 학과     등록 ==");
		System.out.println("== 4. 학과     수정 ==");
		System.out.println("== 5. 학과     삭제 ==");
		System.out.println("== 6. 종  료  하  기==");
		System.out.println("====================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}
	
	public void DepatmentMainMenu() {
		boolean isTrue = false;
		
		do {
			MenuTitle();
			int key = sc.nextInt();
			
			switch(key) {
			case 1:
				// 전체 학과 조회
				departmentList();
				break;
				
			case 2:
				// 학과 검색
				departmentSearch();
				break;
				
			case 3:
				// 학과 등록
				departmentRegister();
				break;
				
			case 4:
				// 학과 수정
				departmentEdit();
				break;
				
			case 5:
				// 학과 삭제
				departmentDelete();
				break;
				
			case 6:
				isTrue = true;
				break;
			}
			
		}while(!isTrue);
		System.out.println(">> 종료합니다! <<");
	}
	
	private void departmentList() {
		vo = new DepartVO();
		List<DepartVO> list = new ArrayList<DepartVO>();
		list = ds.departSelectAll();
		
		System.out.println("====전체 학과 조회====");
		for(DepartVO vo : list) {
			vo.toString();
			System.out.println("__________________");
		}
	}
	
	private void departmentSearch() {
		vo = new DepartVO();
		System.out.println("====학과     검색====");
		System.out.println("검색할 학과의 코드를 입력하세요 : ");
		vo.setDeptCode(sc.next());
		ds.departSelect(vo);
		vo.toString();
	}
	
	private void departmentRegister() {
		vo = new DepartVO();
		System.out.println("====학과     등록====");
		System.out.println("등록할 학과코드를 입력하세요 : ");
		vo.setDeptCode(sc.next());
		System.out.println("등록할 학과의 이름을 입력하세요 : ");
		vo.setDeptName(sc.next());
		
		int n = ds.departInsert(vo);
		
		if(n != 0) {
			System.out.println(">> 학과 등록이 완료되었습니다. <<");
		}else {
			System.out.println(">> 학과 등록에 실패했습니다.");
		}
	}
	
	private void departmentEdit() {
		vo = new DepartVO();
		System.out.println("====학과     수정====");
		System.out.println("수정할 학과의 코드를 입력하세요 : ");
		vo.setDeptCode(sc.next());
		System.out.println("수정할 학과의 이름을 입력하세요 : ");
		vo.setDeptName(sc.next());
		
		int n = ds.departUpdate(vo);
		
		if(n != 0) {
			System.out.println(">> 정보 수정이 완료되었습니다. <<");
		}else {
			System.out.println(">> 정보 수정에 실패했습니다.");
		}
	}
	
	private void departmentDelete() {
		vo = new DepartVO();
		System.out.println("====학과     삭제====");
		System.out.println("삭제할 학과의 코드를 입력하세요 : ");
		vo.setDeptCode(sc.next());
		
		int n = ds.departDelete(vo);
		
		if(n != 0) {
			System.out.println(">> 학과 삭제가 완료되었습니다. <<");
		}else {
			System.out.println(">> 학과 삭제에 실패했습니다.");
		}
	}

}
