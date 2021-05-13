package co.banya.lms.student.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.banya.lms.common.*;
import co.banya.lms.courserg.menu.CourseRgMenu;
import co.banya.lms.student.service.StudentService;
import co.banya.lms.student.serviceImpl.StudentServiceImpl;
import co.banya.lms.student.vo.StudentVO;

public class StudentMenu implements ScInputOutput{
	private StudentService ss = new StudentServiceImpl();
	StudentVO vo;
		
	private void MenuTitle() {
		System.out.println("=======메   뉴=======");
		System.out.println("== 1. 전체 학생 조회 ==");
		System.out.println("== 2. 학생     검색 ==");
		System.out.println("== 3. 학생 정보 수정 ==");
		System.out.println("== 4. 수강 정보 조회 ==");
		System.out.println("== 5. 수강     신청 ==");
		System.out.println("== 6. 종  료  하  기==");
		System.out.println("====================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}
	
	public void StudentMainMenu() {
		boolean isTrue = false;
		
		do {
			MenuTitle();
			int key = sc.nextInt();
			
			switch(key) {
			case 1:
				// 전체 학생 조회
				studentList();
				break;
				
			case 2:
				// 학생 검색
				studentSearch();
				break;
											
			case 3:
				// 학생 정보 수정
				studentEdit();
				break;
				
			case 4:
				// 수강 정보 조회
				studentEnrol();
				break;
				
			case 5:
				// 수강 신청
				CourseRgMenu csm = new CourseRgMenu();
				csm.CourseRgMainMenu();
				break;
				
			case 6:
				isTrue = true;
				break;
			}
			
		}while(!isTrue);
	}
	
	
	private void studentList() {
		vo = new StudentVO();
		List<StudentVO> list = new ArrayList<StudentVO>();
		list = ss.studentSelectAll();
		
		System.out.println("====전체 학생 조회====");		
		for(StudentVO vo : list) {
			vo.toString();
		}
	}
	
	private void studentSearch() {
		vo = new StudentVO();
		System.out.println("====학생     검색====");
		System.out.println("검색할 학생의 학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		ss.studentSelect(vo);
		
		vo.toString();
		
	}
	
	private void studentEdit() {
		vo = new StudentVO();
		System.out.println("====학생 정보 수정====");
		System.out.println("수정할 학생의 학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		System.out.println("수정할 이름을 입력하세요 : ");
		vo.setStudentName(sc.next());
		System.out.println("수정할 학과번호를 입력하세요 : ");
		vo.setDeptCode(sc.next());
		System.out.println("수정할 전화번호를 입력하세요 : ");
		vo.setPhone(sc.next());
		System.out.println("수정할 비밀번호를 입력하세요 : ");
		vo.setPassword(sc.next());
		
		int n = ss.studentUpdate(vo);
		
		if(n != 0) {
			System.out.println(">> 정보 수정이 완료되었습니다. <<");
		}else {
			System.out.println(">> 정보 수정에 실패했습니다.");
		}
		
	}
	
	private void studentEnrol() {
		vo = new StudentVO();
		
		System.out.println("====수강정보     조회====");
		System.out.println("검색할 학생의 학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		
		ss.ErolmentSelect(vo);
		vo.toString();
	}	
	
}
