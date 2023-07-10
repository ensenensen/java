package ex07;

import java.sql.*;
import java.util.*;

public class ProductDAOImpl implements ProductDAO{
	Connection con = Database.connect();
	@Override
	public void insert(ProductVO vo) throws Exception {
		String sql = "insert into products(pcode,pname,pprice) values(seq_pcode.nextval,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getPname());
		ps.setInt(2, vo.getPprice());
		ps.execute();	
	}

	@Override
	public void update(ProductVO vo) throws Exception {
		String sql = "update products set pname=?,pprice=? where pcode=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getPname());
		ps.setInt(2, vo.getPprice());
		ps.setInt(3, vo.getPcode());
		ps.execute();
		
	}

	@Override
	public void delete(int pcode) throws Exception {
		String sql = "delete from products where pcode=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pcode);
		ps.execute();
		
	}

	@Override
	public ProductVO read(int pcode) throws Exception {
		ProductVO vo = new ProductVO();
		
		String sql = "select * from products where pcode=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pcode);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			vo.setPcode(rs.getInt("pcode"));
			vo.setPname(rs.getString("pname"));
			vo.setPprice(rs.getInt("pprice"));
		}
		
		return vo;
	}

	@Override
	public List<ProductVO> list() throws Exception {
		List<ProductVO> array = new ArrayList<>();
		
		String sql = "select * from products order by pcode desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ProductVO vo = new ProductVO();
			vo.setPcode(rs.getInt("pcode"));
			vo.setPname(rs.getString("pname"));
			vo.setPprice(rs.getInt("pprice"));
			array.add(vo);
		}
		
		return array;
	}
	
}
