package co.banya.lms.courserg.vo;

public class CourseRgVO {
	private String studentId;
	private String courseId;
	

	public CourseRgVO() {}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	

	public String toString() {
		
		System.out.println("학   번 : " + studentId);
		System.out.println("과목코드 : " + courseId);
				
		return null;
	}
}
