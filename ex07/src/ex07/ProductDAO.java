package ex07;

import java.util.List;

public interface ProductDAO {
	public void insert(ProductVO vo) throws Exception;
	public void update(ProductVO vo) throws Exception;
	public void delete(int pcode) throws Exception;
	public ProductVO read(int pcode) throws Exception;
	public List<ProductVO> list() throws Exception;
} 
