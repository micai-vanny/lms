package co.banya.lms.enrolment.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.banya.lms.common.DataSource;
import co.banya.lms.enrolment.service.EnrolmentService;
import co.banya.lms.enrolment.vo.EnrolmentVO;

public class EnrolmentServiceImpl implements EnrolmentService {
	
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	EnrolmentVO vo;

	@Override
	public List<EnrolmentVO> EnrolmentSelectAll() {
		List<EnrolmentVO> list = new ArrayList<EnrolmentVO>();
		
		String sql = "select * from enrolment";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new EnrolmentVO();
				vo.setStudentId(rs.getString("studentId"));
				vo.setStudentName(rs.getString("studentName"));
				vo.setCourseId(rs.getString("courseId"));
				vo.setCourseName(rs.getString("courseName"));
				vo.setProfessorId(rs.getString("professorId"));
				vo.setProfessorName(rs.getString("professorName"));
				vo.setCourseScore(rs.getInt("courseScore"));
				vo.setCourseGrade(rs.getString("courseGrade"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	public EnrolmentVO EnrolmentSelect(EnrolmentVO vo) {
				
		String sql = "select * from enrolment where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentId"));
				vo.setStudentName(rs.getString("studentName"));
				vo.setCourseId(rs.getString("courseId"));
				vo.setCourseName(rs.getString("courseName"));
				vo.setProfessorId(rs.getString("professorId"));
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

	@Override
	public int EnrolmentInsert(EnrolmentVO vo) {
		int n = 0;
		
		String sql = "insert into enrolment values(?,?,?,?,?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getStudentName());
			psmt.setString(3, vo.getCourseId());
			psmt.setString(4, vo.getCourseName());
			psmt.setString(5, vo.getProfessorId());
			psmt.setString(6, vo.getProfessorName());
			psmt.setInt(7, vo.getCourseScore());
			psmt.setString(8, vo.getCourseGrade());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int EnrolmentUpdate(EnrolmentVO vo) {
		int n = 0;
		
		String sql = "update enrolment set coursescore = ?, coursegrade = ? "
				+ "where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, vo.getCourseScore());
			psmt.setString(2, vo.getCourseGrade());
			psmt.setString(3, vo.getStudentId());
			
			
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int EnrolmentDelete(EnrolmentVO vo) {
		int n = 0;
		
		String sql = "delete from enrolment where studentid = ?";
		
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
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
