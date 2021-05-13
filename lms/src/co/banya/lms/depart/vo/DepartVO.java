package co.banya.lms.depart.vo;

public class DepartVO {
	
	private String deptCode;
	private String deptName;
	
	public DepartVO() {
		
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
	
	public String toString() {
		System.out.println("학과번호 : " + deptCode);
		System.out.println("학과이름 : " + deptName);
		return null;
	}
}
