package co.banya.lms.professor.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.banya.lms.adminmenu.*;
import co.banya.lms.common.*;
import co.banya.lms.professor.menu.ProfessorMenu;
import co.banya.lms.professor.service.ProfessorService;
import co.banya.lms.professor.vo.ProfessorVO;
import co.banya.lms.student.vo.StudentVO;

public class ProfessorServiceImpl implements ProfessorService, LoginService<ProfessorVO>,ScInputOutput {

	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	ProfessorVO vo;
	
	@Override
	public ProfessorVO login(ProfessorVO vo) {
		ProfessorMenu pm = new ProfessorMenu();
		AdminMenu am = new AdminMenu();
		System.out.println("=======로 그 인=======");
		System.out.println("교수코드를 입력하세요 : ");
		vo.setProfessorId(sc.next());
		System.out.println("password를 입력하세요 : ");
		vo.setPassword(sc.next());
		
		loginCheck(vo);
		
		if(vo.getProfessorName() != null) {
			System.out.println();
			System.out.println(">>>>" + vo.getProfessorName() + "님 환영합니다.");
			System.out.println();
			am.mainMenu();
			
		}else {
			System.out.println("ID 또는 password가 일치하지 않습니다.");
		}
		return vo;
	}
	
	@Override
	public List<ProfessorVO> professorSelectAll() {
		List<ProfessorVO> list = new ArrayList<ProfessorVO>();
		String sql = "select p.*, deptname from professor p, depart b "
				+ "where p.deptcode = b.deptcode";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ProfessorVO();
				vo.setProfessorId(rs.getString("professorId"));
				vo.setProfessorName(rs.getString("professorName"));
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
	public ProfessorVO professorSelect(ProfessorVO vo) {
		
		String sql = "select p.*, deptname from professor p, depart b "
				+ "where p.deptcode = b.deptcode and professorid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProfessorId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setProfessorName(rs.getString("professorName"));
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
	public int professorInsert(ProfessorVO vo) {
		
		String sql = "insert into professor values(?,?,?,?)";
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProfessorId());
			psmt.setString(2, vo.getProfessorName());
			psmt.setString(3, vo.getDeptCode());
			psmt.setString(4, vo.getPassword());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}


	@Override
	public int professorUpdate(ProfessorVO vo) {
		int n = 0;
		
		String sql = "update professor set professorid = ?, professorname = ?, deptcode = ?, "
				+ "password = ? where professorid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProfessorId());
			psmt.setString(2, vo.getProfessorName());
			psmt.setString(3, vo.getDeptCode());
			psmt.setString(4, vo.getPassword());
			psmt.setString(5, vo.getProfessorId());
			
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int professorDelete(ProfessorVO vo) {
		int n = 0;
		
		String sql = "delete from professor where professorid = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProfessorId());
			
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

	@Override
	public String idCheck(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessorVO loginCheck(ProfessorVO vo) {
		String sql = "select * from professor where professorid = ? and password = ?";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getProfessorId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setProfessorName(rs.getString("professorName"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

}
