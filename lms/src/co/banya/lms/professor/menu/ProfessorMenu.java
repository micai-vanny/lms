package co.banya.lms.professor.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.banya.lms.professor.service.ProfessorService;
import co.banya.lms.professor.serviceImpl.ProfessorServiceImpl;
import co.banya.lms.professor.vo.ProfessorVO;
import co.banya.lms.student.vo.StudentVO;

public class ProfessorMenu {
	private ProfessorService ps = new ProfessorServiceImpl();
	ProfessorVO vo;
	Scanner sc = new Scanner(System.in);
	
	private void MenuTitle() {
		System.out.println("=======메   뉴=======");
		System.out.println("== 1. 전체 교수 조회 ==");
		System.out.println("== 2. 교수     검색 ==");
		System.out.println("== 3. 교수     등록 ==");
		System.out.println("== 4. 교수 정보 수정 ==");
		System.out.println("== 5. 교수     삭제 ==");
		System.out.println("== 6. 종  료  하  기==");
		System.out.println("====================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}
	
	public void ProfessorMainMenu() {
		boolean isTrue = false;
		
		do {
			MenuTitle();
			int key = sc.nextInt();
			
			switch(key) {
			case 1:
				// 전체 교수 조회
				professorList();
				break;
				
			case 2:
				// 교수 검색
				professorSearch();
				break;
				
			case 3:
				// 교수 등록
				professorRegister();
				break;
				
			case 4:
				// 교수 정보 수정
				professorEdit();
				break;
				
			case 5:
				// 교수 삭제
				professorDelete();
				break;
				
			case 6:
				isTrue = true;
				break;
			}
			
		}while(!isTrue);
		System.out.println(">> 종료합니다! <<");
		sc.close();
	}
	
	
	private void professorList() {
		vo = new ProfessorVO();
		List<ProfessorVO> list = new ArrayList<ProfessorVO>();
		list = ps.professorSelectAll();
		
		System.out.println("====전체 교수 조회====");		
		for(ProfessorVO vo : list) {
			vo.toString();
		}
	}
	
	private void professorSearch() {
		vo = new ProfessorVO();
		System.out.println("====교수     검색====");
		System.out.println("검색할 교수의 사번을 입력하세요 : ");
		vo.setProfessorId(sc.next());
		ps.professorSelect(vo);
		
		vo.toString();
		
	}
	
	private void professorRegister() {
		vo = new ProfessorVO();
		System.out.println("====교수     등록====");
		System.out.println("사번을 입력하세요 : ");
		vo.setProfessorId(sc.next());
		System.out.println("이름을 입력하세요 : ");
		vo.setProfessorName(sc.next());
		System.out.println("학과번호를 입력하세요 : ");
		vo.setDeptName(sc.next());
		System.out.println("비밀번호를 입력하세요 : ");
		vo.setPassword(sc.next());
		
		int n = ps.professorInsert(vo);
		
		if(n != 0) {
			System.out.println(">> 교수 등록이 완료되었습니다. <<");
		}else {
			System.out.println(">> 교수 등록에 실패했습니다.");
		}
		
	}
	
	private void professorEdit() {
		vo = new ProfessorVO();
		System.out.println("====교수 정보 수정====");
		System.out.println("수정할 교수의 사번을 입력하세요 : ");
		vo.setProfessorId(sc.next());
		System.out.println("수정할 이름을 입력하세요 : ");
		vo.setProfessorName(sc.next());
		System.out.println("수정할 학과번호를 입력하세요 : ");
		vo.setDeptName(sc.next());
		System.out.println("수정할 비밀번호를 입력하세요 : ");
		vo.setPassword(sc.next());
		
		int n = ps.professorUpdate(vo);
		
		if(n != 0) {
			System.out.println(">> 정보 수정이 완료되었습니다. <<");
		}else {
			System.out.println(">> 정보 수정에 실패했습니다.");
		}
		
	}
	
	private void professorDelete() {
		vo = new ProfessorVO();
		System.out.println("====교수     삭제====");
		System.out.println("삭제할 교수의 학번을 입력하세요 : ");
		vo.setProfessorId(sc.next());
		
		int n = ps.professorDelete(vo);
		
		if(n != 0) {
			System.out.println(">> 교수 삭제가 완료되었습니다. <<");
		}else {
			System.out.println(">> 교수 삭제에 실패했습니다.");
		}
		
	}
	
}
