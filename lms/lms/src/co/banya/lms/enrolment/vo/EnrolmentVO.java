package co.banya.lms.enrolment.vo;

public class EnrolmentVO {
	
	private String studentId;
	private String studentName;
	private String courseId;
	private String courseName;
	private String professorId;
	private String professorName;
	private int courseScore;
	private String courseGrade;
	
	public EnrolmentVO() {
		
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public int getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(int courseScore) {
		this.courseScore = courseScore;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	
	public String toString() {
		
		System.out.println("학생번호 : " + studentId);
		System.out.println("학생이름 : " + studentName);
		System.out.println("과목번호 : " + courseId);
		System.out.println("과목이름 : " + courseName);
		System.out.println("교수번호 : " + professorId);
		System.out.println("교수이름 : " + professorName);
		System.out.println("과목점수 : " + courseScore);
		System.out.println("과목등급 : " + courseGrade);
		return null;
	}

}
