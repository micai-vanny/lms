package co.banya.lms.professor.vo;

public class ProfessorVO {
		
	private String professorId;
	private String professorName;
	private String deptCode;
	private String deptName;
	private String password;
	
	public String loginCheck;
	public String login;
	
	
	public ProfessorVO() {
		
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

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

	public String toString() {
		
		System.out.println("====================");
		System.out.println("교수번호 : " + professorId);
		System.out.println("교수명 : " + professorName);
		System.out.println("학과명 : " + deptName);
		
		return null;
	}
	
	
}
