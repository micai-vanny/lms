package co.banya.lms.student.vo;

public class StudentVO {
	private String studentId;
	private String studentName;
	private String deptCode;
	private String deptName;
	private String phone;
	private String password;
	private String courseName;
	private String professorName;
	private String courseId;
	private int courseScore;
	private String courseGrade;
	private String courseRegist;
	private int entry;
	
	public String login;
	public String loginCheck;
	public String idCheck;
	
	public StudentVO() {
		
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


	public String getDeptCode() {
		return deptCode;
	}


	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getProfessorName() {
		return professorName;
	}


	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
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


	public String getCourseRegist() {
		return courseRegist;
	}


	public void setCourseRegist(String courseRegist) {
		this.courseRegist = courseRegist;
	}


	public int getEntry() {
		return entry;
	}


	public void setEntry(int entry) {
		this.entry = entry;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getLoginCheck() {
		return loginCheck;
	}


	public void setLoginCheck(String loginCheck) {
		this.loginCheck = loginCheck;
	}


	public String getIdCheck() {
		return idCheck;
	}


	public void setIdCheck(String idCheck) {
		this.idCheck = idCheck;
	}


	public String toString() {
		
		System.out.println("====================");
		System.out.println("학번 : " + studentId);
		System.out.println("이름 : " + studentName);
		System.out.println("학과 : " + deptName);
		if(courseName != null) {
			System.out.println("수강과목 : " +  courseName);	
		}
		if(professorName != null) {
			System.out.println("교수이름 : " + professorName);
		}
		if(phone != null) {
			System.out.println("전화 : " + phone);
		}
		if(courseScore != 0) {
			System.out.println("과목점수 : " + courseScore);
		}
		if(courseGrade != null) {
			System.out.println("과목등급 : " + courseGrade);
		}
		
		return null;
	}

	
}
