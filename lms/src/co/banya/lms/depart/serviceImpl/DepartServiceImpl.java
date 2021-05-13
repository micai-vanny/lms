package co.banya.lms.depart.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.banya.lms.common.DataSource;
import co.banya.lms.depart.service.DepartService;
import co.banya.lms.depart.vo.DepartVO;

public class DepartServiceImpl implements DepartService {
	
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	DepartVO vo;

	@Override
	public List<DepartVO> departSelectAll() {
		List<DepartVO> list = new ArrayList<DepartVO>();
		String sql = "select * from depart";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new DepartVO();
				vo.setDeptCode(rs.getString("deptCode"));
				vo.setDeptName(rs.getString("deptName"));
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
	public DepartVO departSelect(DepartVO vo) {
		
		String sql = "select * from depart where deptcode = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDeptCode());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setDeptCode(rs.getString("deptCode"));
				vo.setDeptName(rs.getString("deptName"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int departInsert(DepartVO vo) {
		int n = 0;
		
		String sql = "insert into depart values(?,?)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDeptCode());
			psmt.setString(2, vo.getDeptName());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int departUpdate(DepartVO vo) {
		int n = 0;
		
		String sql = "update depart set deptcode = ?, deptname = ? "
				+ "where deptcode = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDeptCode());
			psmt.setString(2, vo.getDeptName());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int departDelete(DepartVO vo) {
		int n = 0;
		
		String sql = "delete from depart where deptcode = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDeptCode());
			
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
