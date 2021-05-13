package co.banya.lms.courserg.menu;

import co.banya.lms.common.Entry;
import co.banya.lms.common.ScInputOutput;
import co.banya.lms.course.service.CourseService;
import co.banya.lms.course.serviceImpl.CourseServiceImpl;
import co.banya.lms.courserg.service.CourseRgService;
import co.banya.lms.courserg.serviceImpl.CourseRgServiceImpl;
import co.banya.lms.courserg.vo.CourseRgVO;

public class CourseRgMenu implements ScInputOutput {
	private CourseRgService crs = new CourseRgServiceImpl();
	CourseRgVO vo;
	
	private void MenuTitle() {
		System.out.println("========메   뉴=======");
		System.out.println("== 1. 수  강  신  청 ==");
		System.out.println("== 2. 수  강  정  정 ==");
		System.out.println("== 3. 수  강  취  소 ==");
		System.out.println("== 4. 돌  아  가  기==");
		System.out.println("====================");
		
		System.out.println("원하는 작업번호를 선택하세요 : ");
	}
	
	public void CourseRgMainMenu() {
		boolean isTrue = false;
		int key = 0;
		do {
			MenuTitle();
			key = sc.nextInt();
			
			switch(key) {
			case 1:
				courseRegister();
				break;
				
			case 2:
				courseEdit();
				break;
				
			case 3:
				courseCancel();
				break;
				
			case 4:
				isTrue = true;
				break;
			
			}
		}while(!isTrue);
	}
	
	private void courseRegister() {
		vo = new CourseRgVO();
		CourseService cs = new CourseServiceImpl();
				
		System.out.println("====수강       신청====");
		System.out.println("학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		System.out.println("신청할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		
		Entry.cId = vo.getCourseId();
//		System.out.println(vo.getCourseId());
		int n = crs.courseRgInsert(vo);
		
		if(n != 0) {
			if(vo.getCourseId() != null) {
				cs.entryCheck(Entry.cId);	// 수강가능 인원 체크
			}
			if(Entry.entry >  0) {
				cs.entryCount(vo.getCourseId());	// 해당 과목 수강가능 인원 1씩 차감
				System.out.println("해당 과목 수강 신청이 완료되었습니다.");
			}
		}else {
			 	if(Entry.entry == 0) {	// 해당 과목의 수강가능 인원이 0이면
				System.out.println("해당 과목의 수강 신청이 마감되었습니다.");
			}
			System.out.println("수강신청에 실패하였습니다.");
		}
	
	}
	
	private void courseEdit() {
		vo = new CourseRgVO();
		CourseService cs = new CourseServiceImpl();
		
		System.out.println("====수강       정정====");
		System.out.println("학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		System.out.println("새로 신청할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		Entry.cId = vo.getCourseId();
		int n = crs.courseRgUpdate(vo);
		
		if(n != 0) {
			if(vo.getCourseId() != null) {
				cs.entryCheck(Entry.cId);	// 수강가능 인원 체크
			}
			if(Entry.entry >  0) {
				cs.entryCount(vo.getCourseId());	// 해당 과목 수강가능 인원 1씩 차감
				System.out.println("해당 과목 수강 정정이 완료되었습니다.");
			}
			if(vo.getCourseId().equals(Entry.preCourseId)) {
				cs.entryRestore(Entry.preCourseId); 	// 해당과목 수강 가능 인원 1 증가
			}
		}else {
			 	if(Entry.entry == 0) {	// 해당 과목의 수강가능 인원이 0이면
				System.out.println("해당 과목의 수강 신청이 마감되었습니다.");
			}
			System.out.println("수강정정에 실패하였습니다.");
		}
		
	}
	
	private void courseCancel() {
		vo = new CourseRgVO();
		CourseService cs = new CourseServiceImpl();
		
		System.out.println("====수강       취소====");
		System.out.println("학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		System.out.println("취소할 과목코드를 입력하세요 : ");
		vo.setCourseId(sc.next());
		
//		Entry.cId = vo.getCourseId();
		int n = crs.courseRgDelete(vo);
		
		if(n != 0) {
			cs.entryRestore(vo.getCourseId()); 	// 해당과목 수강 가능 인원 1 증가
			System.out.println(">> 수강취소가 완료되었습니다. <<");
		}else {
			System.out.println(">> 수강취소에 실패했습니다. <<");
		}
		
	}

}
