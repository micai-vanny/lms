package co.banya.lms.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.banya.lms.common.DataSource;
import co.banya.lms.common.LoginIdSave;
import co.banya.lms.common.LoginService;
import co.banya.lms.student.menu.StudentMenu;
import co.banya.lms.student.service.StudentService;
import co.banya.lms.student.vo.StudentVO;

public class StudentServiceImpl implements StudentService, LoginService<StudentVO> {

	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	StudentVO vo;
	
	@Override
	public StudentVO login(StudentVO vo) {
		StudentMenu sm = new StudentMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("=======로 그 인=======");
		System.out.println("학번을 입력하세요 : ");
		vo.setStudentId(sc.next());
		System.out.println("password를 입력하세요 : ");
		vo.setPassword(sc.next());
//		LoginIdSave.loginId = vo.getStudentId();
		loginCheck(vo);
		
		if(vo.getStudentName() != null) {
			System.out.println();
			System.out.println(">>>>" +  vo.getStudentName() + "님 환영합니다.");
			System.out.println();
			
			sm.StudentMainMenu();
		}else {
			System.out.println("ID 또는 password가 일치하지 않습니다.");
		}
		return vo;
	}

	@Override
	public List<StudentVO> studentSelectAll() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		String sql = "select a.*, deptname "
				+ "from student a, depart b where a.deptcode = b.deptcode";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new StudentVO();
				vo.setStudentId(rs.getString("studentId"));
				vo.setStudentName(rs.getString("studentName"));
				vo.setDeptName(rs.getString("deptName"));
				vo.setPhone(rs.getString("phone"));
				list.add(vo);			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		
		String sql = "select a.*, deptname from student a, depart b "
				+ "where a.deptcode = b.deptcode and studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setStudentName(rs.getString("studentName"));
				vo.setDeptName(rs.getString("deptName"));
				vo.setPhone(rs.getString("phone"));
				}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int studentInsert(StudentVO vo) {
		
		String sql = "insert into student (studentid, studentname, deptcode, phone, password) values(?,?,?,?,?)";
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getStudentName());
			psmt.setString(3, vo.getDeptCode());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getPassword());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		int n = 0;
		
		String sql = "update student set studentname = ?, deptcode = ?,"
				+ "phone = ?, password = ? where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getStudentName());
			psmt.setString(2, vo.getDeptCode());
			psmt.setString(3, vo.getPhone());
			psmt.setString(4, vo.getPassword());
			psmt.setString(5, vo.getStudentId());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int studentDelete(StudentVO vo) {
		int n = 0;
		
		String sql = "delete from student where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	@Override
	public StudentVO ErolmentSelect(StudentVO vo) {

		String sql = "select a.*, d.deptname, e.coursename, e.professorname, e.coursescore, e.coursegrade "
				+ "from student a, depart d, enrolment e where a.studentid = ? "
				+ "and a.studentid = e.studentid and a.deptcode = d.deptcode";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentId"));
				vo.setStudentName(rs.getString("studentName"));
				vo.setDeptName(rs.getString("deptName"));
				vo.setCourseName(rs.getString("courseName"));
				vo.setProfessorName(rs.getString("professorName"));
				vo.setCourseScore(rs.getInt("courseScore"));
				vo.setCourseGrade(rs.getString("courseGrade"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String idCheck(String studentId) {
		String sql = "select studentid from student where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				studentId = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return studentId;
	}

	@Override
	public StudentVO loginCheck(StudentVO vo) {
		String sql = "select * from student where studentid = ? and password = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setStudentName(rs.getString("studentName"));
				vo.setPhone(rs.getString("phone"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int courseRegist(StudentVO vo) {
		int n = 0;
		String sql = "update student set courseid = ? where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCourseId());
			psmt.setString(2, vo.getStudentId());
			
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public void entryCount(String courseId) {
//		int n = 0;
		String sql = "update course set entry = entry -1 where courseid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCourseId());
			psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

}
