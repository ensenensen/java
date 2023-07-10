package ex07;

import java.sql.*;
import java.util.*;

public class SaleDAO {
	Connection con = Database.connect();
	
	//상품별 판매현황
	public List<SaleVO> sum_list(){
		List<SaleVO> array = new ArrayList<>();
		try {
			String sql="SELECT PCODE, PNAME, SUM(QNT) sum_qnt, SUM(SPRICE*QNT) sum_price\r\n"
					+ "FROM VIEW_SALE \r\n"
					+ "GROUP BY PCODE, PNAME\r\n"
					+ "ORDER BY PCODE";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SaleVO vo = new SaleVO();
				vo.setPcode(rs.getInt("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setQnt(rs.getInt("sum_qnt"));
				vo.setSprice(rs.getInt("sum_price"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("판매현황:"+e.toString());
		}
		
		return array;
	}
	
	//판매등록
	public void insert(SaleVO vo)throws Exception {
		String sql="insert into sale(scode,pcode,qnt,sprice) values(seq_scode.nextval,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, vo.getPcode());
		ps.setInt(2, vo.getQnt());
		ps.setInt(3, vo.getSprice());
		ps.execute();
	}
	
	//상품별 판매목록
	public List<SaleVO> list(int pcode)throws Exception{
		List<SaleVO> array = new ArrayList<>();
		String sql = "select * from sale where pcode=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pcode);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			SaleVO vo = new SaleVO();
			vo.setPcode(rs.getInt("pcode"));
			vo.setScode(rs.getInt("scode"));
			vo.setQnt(rs.getInt("qnt"));
			vo.setSprice(rs.getInt("sprice"));
			vo.setSdate(rs.getTimestamp("sdate"));
			array.add(vo);
		}
		
		return array;
	}
}
