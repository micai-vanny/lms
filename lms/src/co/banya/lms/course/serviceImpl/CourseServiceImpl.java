package co.banya.lms.course.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.banya.lms.common.DataSource;
import co.banya.lms.course.service.CourseService;
import co.banya.lms.course.vo.CourseVO;

public class CourseServiceImpl implements CourseService {
	
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	CourseVO vo;

	@Override
	public List<CourseVO> CourseSelectAll() {
		List<CourseVO> list = new ArrayList<CourseVO>();
		String sql = "select c.*, d.deptname, p.professorname "
				+ "from course c, depart d, professor p "
				+ "where c.deptcode = d.deptcode and c.professorid = p.professorid";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new CourseVO();
				vo.setCourseId(rs.getString("courseId"));
				vo.setGrade(rs.getString("grade"));
				vo.setCourseName(rs.getString("courseName"));
				vo.setDeptCode(rs.getString("deptCode"));
				vo.setDeptName(rs.getString("deptName"));
				vo.setProfessorId(rs.getString("professorId"));
				vo.setProfessorName(rs.getString("professorName"));
				vo.setParticipants(rs.getInt("participants"));
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
	public CourseVO CourseSelect(CourseVO vo) {
		String sql = "select c.*, d.deptname, p.professorname "
				+ "from course c, depart d, professor p "
				+ "where c.deptcode = d.deptcode and c.professorid = p.professorid "
				+ "and courseid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCourseId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setCourseId(rs.getString("courseId"));
				vo.setGrade(rs.getString("grade"));
				vo.setCourseName(rs.getString("courseName"));
				vo.setDeptCode(rs.getString("deptCode"));
				vo.setDeptName(rs.getString("deptName"));
				vo.setProfessorId(rs.getString("professorId"));
				vo.setProfessorName(rs.getString("professorName"));
				vo.setParticipants(rs.getInt("participants"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int CourseInsert(CourseVO vo) {
		int n = 0;
		
		String sql = "insert into course values(?,?,?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCourseId());
			psmt.setString(2, vo.getGrade());
			psmt.setString(3, vo.getCourseName());
			psmt.setString(4, vo.getDeptCode());
			psmt.setString(5, vo.getProfessorId());
			psmt.setInt(6, vo.getParticipants());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int CourseUpdate(CourseVO vo) {
		int n = 0;
		
		String sql = "update course set courseid = ?, grade = ?, coursename = ?,"
				+ "deptcode = ?, professorid = ?, participants = ? where courseid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCourseId());
			psmt.setString(2, vo.getGrade());
			psmt.setString(3, vo.getCourseName());
			psmt.setString(4, vo.getDeptCode());
			psmt.setString(5, vo.getProfessorId());
			psmt.setInt(6, vo.getParticipants());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int CourseDelete(CourseVO vo) {
		int n = 0;
		
		String sql = "delete from course where courseid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCourseId());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
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

}
