package ex08;

import java.sql.*;
import java.util.*;

public class DetailDAO {
	Connection con=Database.connect();
	
	public void insert(DetailVO vo) {
		try {
			String sql="INSERT INTO DETAIL(DNO, ANO, AMOUNT, TYPE, DDATE) VALUES(SEQ_DNO.NEXTVAL, ?, ?, ?, SYSDATE)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, vo.getAno());
			ps.setInt(2, vo.getAmount());
			ps.setString(3, vo.getType());
			ps.execute();
		}catch(Exception e) {
			System.out.println("거래내역등록:"+e.toString());
		}
	}
	
	//특정계좌의 거래내역
	public List<DetailVO> list(int ano){
		List<DetailVO> array = new ArrayList<>();
		try {
			String sql="SELECT * FROM DETAIL WHERE ANO=? ORDER BY DNO DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ano);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DetailVO vo = new DetailVO();
				vo.setAno(rs.getInt("ano"));
				vo.setAmount(rs.getInt("amount"));
				vo.setDno(rs.getInt("dno"));
				vo.setType(rs.getString("type"));
				vo.setDdate(rs.getTimestamp("ddate"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("거래내역:"+e.toString());
		}
		
		return array;
	}
}
