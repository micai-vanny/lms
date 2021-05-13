package co.banya.lms.course.vo;

//import co.banya.lms.common.Entry;

public class CourseVO {
	private String courseId;
	private String grade;
	private String courseName;
	private String deptCode;
	private String deptName;
	private String professorId;
	private String professorName;
	private int participants;
	private int entry;
	public String cId;
		
	public CourseVO() {
		
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}


	public int getEntry() {
		return entry;
	}

	public void setEntry(int entry) {
		this.entry = entry;
	}

	public String toString() {
		
		System.out.println("과목번호 : " + courseId);
		System.out.println("수강학년 : " + grade);
		System.out.println("과목이름 : " + courseName);
		System.out.println("학과번호 : " + deptCode);
		System.out.println("교수번호 : " + professorId);
		System.out.println("수강인원 : " + participants);
		return null;
	}

	
}
