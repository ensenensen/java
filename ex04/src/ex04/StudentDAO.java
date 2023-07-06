package ex04;

import java.sql.*;
import java.util.*;

public class StudentDAO {
	Connection con = Database.connect();
	
	// 학생수정
	public void update(StudentVO vo) {
		try {
			String sql = "update tbl_juso set name=?,juso=?,phone=? where no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(4, vo.getSno());
			ps.setString(1, vo.getSname());
			ps.setString(2, vo.getAddress());
			ps.setString(3, vo.getPhone());
			ps.execute();
		}catch(Exception e) {
			System.out.println("학생수정:"+e.toString());
		}
	}
	
	// 학생삭제
	public void delete(int number) {
		try {
			String sql = "delete from tbl_juso where no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, number);
			ps.execute();
		}catch(Exception e) {
			System.out.println("학생삭제:"+e.toString());
		}
	}
	
	// 학생조회
	public StudentVO read(int no) {
		StudentVO vo = new StudentVO();
		try {
			String sql = "select * from tbl_juso where no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setSno(rs.getInt("no"));
				vo.setSname(rs.getString("name"));
				vo.setAddress(rs.getString("juso"));
				vo.setPhone(rs.getString("phone"));
			}		
		} catch (Exception e) {
			System.out.println("학생조회:"+e.toString());
		}
		
		return vo;
	}
	
	// 학생등록
	public void insert(StudentVO vo) {
		try {
			String sql = "insert into tbl_juso(no,name,juso,phone) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getSno());
			ps.setString(2, vo.getSname());
			ps.setString(3, vo.getAddress());
			ps.setString(4, vo.getPhone());
			ps.execute();
		}catch(Exception e) {
			System.out.println("학생등록:"+e.toString());
		}
	}
	
	// 학생목록
	public List<StudentVO> list(){
		List<StudentVO> array = new ArrayList<>();
	
		try {
			String sql = "select * from tbl_juso order by name";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setSno(rs.getInt("no"));
				vo.setSname(rs.getString("name"));
				vo.setAddress(rs.getString("juso"));
				vo.setPhone(rs.getString("phone"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println("학생목록:"+e.toString());
		}
		
		return array;
	}
}
