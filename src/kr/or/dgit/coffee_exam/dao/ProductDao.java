package kr.or.dgit.coffee_exam.dao;

import java.util.List;

import kr.or.dgit.coffee_exam.dao.exception.DAOException;
import kr.or.dgit.coffee_exam.dto.Product;

public class ProductDao implements DAOInterface<Product> {

	@Override
	public void insertItem(Product item) throws DAOException {
		
	}

	@Override
	public void updateItem(Product item) throws DAOException {
		
	}

	@Override
	public void deleteItem(Product item) throws DAOException {
		
	}

	@Override
	public List<Product> selectAllItem() throws DAOException {
		return null;
	}

	@Override
	public Product selectItemByNo(int no) throws DAOException {
		return null;
	}

}
