package co.banya.lms.adminmenu;

import co.banya.lms.common.*;
import co.banya.lms.course.menu.CourseMenu;
import co.banya.lms.enrolment.menu.EnrolmentMenu;
import co.banya.lms.professor.menu.ProfessorMenu;
import co.banya.lms.student.menuforadmin.StuMenu;

public class AdminMenu implements ScInputOutput {
	
	public void menuTitle() {
		System.out.println("======관 리 메 뉴======");
		System.out.println("=== 1. 학생    관리 ===");
		System.out.println("=== 2. 과목    관리 ===");
		System.out.println("=== 3. 수강정보 관리 ===");
		System.out.println("=== 4. 교수    관리 ===");
		System.out.println("=== 5. 돌 아  가 기 ===");
		System.out.println("=====================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}

	public void mainMenu() {
		boolean isTrue = false;
		
		do {
			menuTitle();
			int key = sc.nextInt();
			
			switch(key) {
			case 1:
				// 1. 학생 관리
				StuMenu st = new StuMenu();
				st.StudentMenu();
				break;
				
			case 2:
				// 2. 과목 관리
				CourseMenu cm = new CourseMenu();
				cm.CourseMainMenu();
				break;
				
			case 3:
				//3. 수강정보 관리
				EnrolmentMenu em = new EnrolmentMenu();
				em.EnrolmentMainMenu();
				break;
				
			case 4:
				// 4. 교수 관리
				ProfessorMenu pm = new ProfessorMenu();
				pm.ProfessorMainMenu();
				break;
				
			case 5:
				// 5. 돌아가기
				isTrue = true;
				break;
			}
		}while(!isTrue);
	}
}
