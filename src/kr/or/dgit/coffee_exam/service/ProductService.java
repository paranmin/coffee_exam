package kr.or.dgit.coffee_exam.service;

import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.coffee_exam.dao.ProductDao;
import kr.or.dgit.coffee_exam.dao.ProductSalesDao;
import kr.or.dgit.coffee_exam.dao.exception.DAOException;
import kr.or.dgit.coffee_exam.dto.Product;
import kr.or.dgit.coffee_exam.dto.ProductSales;

public class ProductService {
	private ProductDao prdDao;
	private ProductSalesDao salesDao;
	
	public ProductService() {
		this.prdDao = ProductDao.getInstance();
		this.salesDao = ProductSalesDao.getInstance();
	}

	public void insertProductSale(ProductSales sales) {
		try {
			salesDao.insertItem(sales);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode());
		}
	}
	
	public List<Product> selectProductAllItem() {
		List<Product> list = null;
		try {
			list = prdDao.selectAllItem();
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode());
		}
		
		return list;
	}
	
	public List<ProductSales> selectProductSalesAllItem() {
		List<ProductSales> list = null;
		try {
			list = salesDao.selectAllItem();
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode());
		}
		
		return list;
	}
	
	public Product selectProductByCode(String code) {
		Product searchPrd = null;
		try {
			searchPrd = prdDao.selectItemByCode(code);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode());
		}
		return searchPrd;
	}
}
