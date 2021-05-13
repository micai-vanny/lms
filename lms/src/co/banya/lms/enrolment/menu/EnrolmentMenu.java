package co.banya.lms.enrolment.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.banya.lms.enrolment.service.EnrolmentService;
import co.banya.lms.enrolment.serviceImpl.EnrolmentServiceImpl;
import co.banya.lms.enrolment.vo.EnrolmentVO;

public class EnrolmentMenu {
	private EnrolmentService es = new EnrolmentServiceImpl();
	Scanner sc = new Scanner(System.in);
	EnrolmentVO vo;
	
	private void MenuTitle() {
		System.out.println("=========메   뉴========");
		System.out.println("== 1. 전체 수강정보 조회 ==");
		System.out.println("== 2. 수강정보     검색 ==");
		System.out.println("== 3. 수강정보     등록 ==");
		System.out.println("== 4. 수강정보     수정 ==");
		System.out.println("== 5. 수강정보     삭제 ==");
		System.out.println("== 6. 종   료   하   기==");
		System.out.println("=======================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}
	
	public void EnrolmentMainMenu() {
		boolean isTrue = false;
		
		do {
			MenuTitle();
			int key = sc.nextInt();
			
			switch(key) {
			case 1:
				// 전체 수강정보 조회
				enrolmentList();
				break;
				
			case 2:
				// 수강정보 검색
				enrolmentSearch();
				break;
				
			case 3:
				// 수강정보 등록
				enrolmentRegister();
				break;
				
			case 4:
				// 수강정보 수정
				enrolmentEdit();
				break;
				
			case 5:
				// 수강정보 삭제
				enrolmentDelete();
				break;
				
			case 6:
				isTrue = true;
				break;
			}
			
		}while(!isTrue);
		System.out.println(">> 종료합니다! <<");
		sc.close();
	}
	
	private void enrolmentList() {
		vo = new EnrolmentVO();
		List<EnrolmentVO> list = new ArrayList<EnrolmentVO>();
		list = es.EnrolmentSelectAll();
		
		System.out.println("====전체 수강정보 조회====");
		for(EnrolmentVO vo : list) {
			vo.toString();
			System.out.println("___________________________________");
		}
	}
	
	private void enrolmentSearch() {
		vo = new EnrolmentVO();
		
		System.out.println("====수강정보     검색====");
		System.out.println("검색할 학생의 학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		
		es.EnrolmentSelect(vo);
		vo.toString();
	
	}
	
	private void enrolmentRegister() {
		vo = new EnrolmentVO();
		
		System.out.println("====수강정보     등록====");
		System.out.println("등록할 학생의 학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		System.out.println("등록할 학생의 이름을 입력하세요 : ");
		vo.setStudentName(sc.next());
		System.out.println("등록할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		System.out.println("등록할 과목이름을 입력하세요 : ");
		vo.setCourseName(sc.next());
		System.out.println("수강과목의 교수코드를 입력하세요 : ");
		vo.setProfessorId(sc.next());
		System.out.println("수강과목의 교수이름을 입력하세요 : ");
		vo.setProfessorName(sc.next());
		System.out.println("수강과목의 점수를 입력하세요 : ");
		vo.setCourseScore(sc.nextInt());
		System.out.println("수강과목의 등급을 입력하세요 : ");
		vo.setCourseGrade(sc.next());
		
		int n = es.EnrolmentInsert(vo);
		
		if(n != 0) {
			System.out.println(">> 수강정보 등록이 완료되었습니다. <<");
		}else {
			System.out.println(">> 수강정보 등록에 실패했습니다.");
		}
		
	}
	
	private void enrolmentEdit() {
		vo = new EnrolmentVO();
		
		System.out.println("====수강정보 수정====");
		System.out.println("수정할 학생의 학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		System.out.println("수강과목의 점수를 입력하세요 : ");
		vo.setCourseScore(sc.nextInt());
		System.out.println("수강과목의 등급을 입력하세요 : ");
		vo.setCourseGrade(sc.next());
		
		int n = es.EnrolmentUpdate(vo);
		
		if(n != 0) {
			System.out.println(">> 수강정보 등록이 완료되었습니다. <<");
		}else {
			System.out.println(">> 수강정보 등록에 실패했습니다.");
		}
	}
	
	private void enrolmentDelete() {
		vo = new EnrolmentVO();
		
		System.out.println("====수강정보     삭제====");
		System.out.println("삭제할 학생의 학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		
		int n = es.EnrolmentDelete(vo);
		
		if(n != 0) {
			System.out.println(">> 수강정보 삭제가 완료되었습니다. <<");
		}else {
			System.out.println(">> 수강정보 삭제에 실패했습니다.");
		}
	}
}
