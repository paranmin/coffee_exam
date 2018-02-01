package kr.or.dgit.coffee_exam.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.coffee_exam.dto.Product;

public class ProductDao implements DAOInterface<Product> {

	@Override
	public void insertItem(Product item) throws SQLException {
		
	}

	@Override
	public void updateItem(Product item) throws SQLException {
		
	}

	@Override
	public void deleteItem(Product item) throws SQLException {
		
	}

	@Override
	public List<Product> selectAllItem() throws SQLException {
		return null;
	}

	@Override
	public Product selectItemByNo(int no) throws SQLException {
		return null;
	}

}
