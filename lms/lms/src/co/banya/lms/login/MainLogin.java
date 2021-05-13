package co.banya.lms.login;

import co.banya.lms.common.*;
import co.banya.lms.professor.service.ProfessorService;
import co.banya.lms.professor.serviceImpl.ProfessorServiceImpl;
import co.banya.lms.professor.vo.ProfessorVO;
import co.banya.lms.student.service.StudentService;
import co.banya.lms.student.serviceImpl.StudentServiceImpl;
import co.banya.lms.student.vo.StudentVO;

public class MainLogin implements ScInputOutput {
	
	private StudentService ss = new StudentServiceImpl();
	private ProfessorService ps = new ProfessorServiceImpl();
//	Scanner sc= new Scanner(System.in);
	
	public void menuTitle() {
		System.out.println("======메    뉴======");
		System.out.println("== 1. 학생  로그인 ==");
		System.out.println("== 2. 교직원 로그인 ==");
		System.out.println("== 3. 종 료 하 기  ==");
		System.out.println("===================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}
	
	public void mainMenu() {
		
		boolean isTrue = false;
		
		do {
			menuTitle();
			int key = Integer.parseInt(sc.next());
				
			switch(key) {
			case 1:
				//1. 학생 로그인
				StudentVO vo = new StudentVO();
				ss.login(vo);
				break;
				
			case 2:
				//2. 교직원 로그인
				ProfessorVO vo1 = new ProfessorVO();
				ps.login(vo1);
				
				break;
				
			case 3:
				isTrue = true;
				break;
			}
									 
		}while(!isTrue);
		System.out.println(">> 시스템이 완전히 종료되었습니다. <<");
	 
	}
	
}
