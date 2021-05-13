package co.banya.lms.course.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.banya.lms.course.service.CourseService;
import co.banya.lms.course.serviceImpl.CourseServiceImpl;
import co.banya.lms.course.vo.CourseVO;

public class CourseMenu {
	private CourseService cs = new CourseServiceImpl();
	Scanner sc = new Scanner(System.in);
	CourseVO vo;
	
	private void MenuTitle() {
		System.out.println("=======메   뉴=======");
		System.out.println("== 1. 전체 과목 조회 ==");
		System.out.println("== 2. 과목     검색 ==");
		System.out.println("== 3. 과목     등록 ==");
		System.out.println("== 4. 과목 정보 수정 ==");
		System.out.println("== 5. 과목     삭제 ==");
		System.out.println("== 6. 종  료  하  기==");
		System.out.println("====================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}
	
	public void CourseMainMenu() {
		boolean isTrue = false;
		
		do {
			MenuTitle();
			int key = sc.nextInt();
			
			switch(key) {
			case 1:
				// 전체 과목 조회
				courseList();
				break;
				
			case 2:
				// 과목 검색
				courseSearch();
				break;
				
			case 3:
				// 과목 등록
				courseRegister();
				break;
				
			case 4:
				// 과목 정보 수정
				courseEdit();
				break;
				
			case 5:
				// 과목 삭제
				courseDelete();
				break;
				
			case 6:
				isTrue = true;
				break;
			}
			
		}while(!isTrue);
		System.out.println(">> 종료합니다! <<");
		sc.close();
	}
	
	private void courseList() {
		vo = new CourseVO();
		List<CourseVO> list = new ArrayList<CourseVO>();
		list = cs.CourseSelectAll();
		
		System.out.println("====전체 과목 조회====");
		for(CourseVO vo : list) {
			vo.toString();
			System.out.println("_________________");
		}
	}
	
	private void courseSearch() {
		vo = new CourseVO();
		
		System.out.println("====과목     검색====");
		System.out.println("검색할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		cs.CourseSelect(vo);
		
		vo.toString();
		System.out.println();
	}
	
	private void courseRegister() {
		vo = new CourseVO();
		
		System.out.println("====과목     등록====");
		System.out.println("등록할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		System.out.println("수강 학년을 입력하세요 : ");
		vo.setGrade(sc.next());
		System.out.println("등록할 과목이름을 입력하세요 : ");
		vo.setCourseName(sc.next());
		System.out.println("등록할 과목의 학과코드를 입력하세요 : ");
		vo.setDeptCode(sc.next());
		System.out.println("등록할 과목의 교수코드를 입력하세요 : ");
		vo.setProfessorId(sc.next());
		System.out.println("수강 가능 정원을 입력하세요 : ");
		vo.setParticipants(sc.nextInt());
		
		int n = cs.CourseInsert(vo);
		
		if(n != 0) {
			System.out.println(">> 정상적으로 등록되었습니다. <<");
		}else {
			System.out.println(">> 등록에 실패했습니다. <<");
		}
	}
	
	private void courseEdit() {
		vo = new CourseVO();
		
		System.out.println("====과목 정보 수정====");
		System.out.println("수정할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		System.out.println("수정할 수강 학년을 입력하세요 : ");
		vo.setGrade(sc.next());
		System.out.println("수정할 과목이름을 입력하세요 : ");
		vo.setCourseName(sc.next());
		System.out.println("수정할 과목의 학과코드를 입력하세요 : ");
		vo.setDeptCode(sc.next());
		System.out.println("수정할 과목의 교수코드를 입력하세요 : ");
		vo.setProfessorId(sc.next());
		System.out.println("수정할 과목의 수강 정원을 입력하세요 : ");
		vo.setParticipants(sc.nextInt());
		
		int n = cs.CourseUpdate(vo);
		
		if(n != 0) {
			System.out.println(">> 정보 수정이 완료되었습니다. <<");
		}else {
			System.out.println(">> 정보 수정에 실패했습니다.");
		}
	}
	
	private void courseDelete() {
		vo = new CourseVO();
		
		System.out.println("====과목     삭제====");
		System.out.println("삭제할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		
		int n = cs.CourseDelete(vo);
		
		if(n != 0) {
			System.out.println(">> 과목 삭제가 완료되었습니다. <<");
		}else {
			System.out.println(">> 과목 삭제에 실패했습니다.");
		}
	}
}
