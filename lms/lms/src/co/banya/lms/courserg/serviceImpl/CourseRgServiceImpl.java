package co.banya.lms.courserg.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.banya.lms.common.DataSource;
import co.banya.lms.common.Entry;
import co.banya.lms.course.service.CourseService;
import co.banya.lms.course.serviceImpl.CourseServiceImpl;
import co.banya.lms.courserg.service.CourseRgService;
import co.banya.lms.courserg.vo.CourseRgVO;

public class CourseRgServiceImpl implements CourseRgService {
	
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	CourseRgVO vo;

	@Override
	public List<CourseRgVO> courseRgSelectAll() {
		List<CourseRgVO> list = new ArrayList<CourseRgVO>();
		String sql = "select * courseregist";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new CourseRgVO();
				vo.setStudentId(rs.getString("studentId"));
				vo.setCourseId(rs.getString("courseId"));
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
	public CourseRgVO courseRgSelect(CourseRgVO vo) {
		String sql = "select * from courseregist where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentId"));
				vo.setCourseId(rs.getString("courseId"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int courseRgInsert(CourseRgVO vo) {
		int n = 0;
		CourseService cs = new CourseServiceImpl();
		String sql = "insert into courseregist values(?,?)";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getCourseId());
			
			
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int courseRgUpdate(CourseRgVO vo) {
		int n = 0;
//		CourseService cs = new CourseServiceImpl();
		String sql = "update courseregist set courseid = ?";
		
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

	@Override
	public int courseRgDelete(CourseRgVO vo) {
		int n = 0;
		
		String sql = "delete from courseregist where studentid = ?";
		
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
	
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override	// 기존 수강신청되어있는 과목코드 저장
	public CourseRgVO preCourseId(CourseRgVO vo) {
		String sql = "select courseid from courseregist where studentid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setCourseId(rs.getString("courseId"));
			}
			
			Entry.preCourseId = vo.getCourseId();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}



}
